package heal.com.healdoctor.profile.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import heal.com.healdoctor.R;
import heal.com.healdoctor.helper.NetworkHelper;
import heal.com.healdoctor.helper.SharedPreferenceHelper;
import heal.com.healdoctor.helper.SharedPreferenceHelper.Keys;
import heal.com.healdoctor.helper.UIHelper;
import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.profile.model.entity.ProfileResponse;
import heal.com.healdoctor.profile.model.entity.Specialization;
import heal.com.healdoctor.profile.model.interactor.ProfileInteractorImpl;
import heal.com.healdoctor.profile.model.presenter.ProfilePresenter;
import me.relex.circleindicator.CircleIndicator;

public class ProfileActivity extends AppCompatActivity implements ProfileView {

    @BindView(R.id.toolbar_profile_main)
    Toolbar toolbar;

    @BindView(R.id.vp_profile_main)
    ViewPager viewPagerMain;

    @BindView(R.id.ci_profile_main)
    CircleIndicator circleIndicatorMain;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_skip)
    Button btnSkip;

    @BindView(R.id.welcome_rl_bottom)
    RelativeLayout welcomeRlBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ButterKnife.bind(this);

        setup();

        getProfileDetails();
        getSpecialization();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setup() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.my_profile);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        viewPagerMain.setAdapter(new ProfileSectionAdapter(getSupportFragmentManager(), null));
        viewPagerMain.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        btnSkip.setText("");
                        btnSkip.setVisibility(View.INVISIBLE);
                        btnNext.setText(R.string.next);
                        btnNext.setVisibility(View.VISIBLE);
                        break;

                    case 1:
                        btnSkip.setText(R.string.back);
                        btnSkip.setVisibility(View.VISIBLE);
                        btnNext.setText(R.string.next);
                        btnNext.setVisibility(View.VISIBLE);

                        break;
                    case 2:
                        btnSkip.setText(R.string.back);
                        btnSkip.setVisibility(View.VISIBLE);
                        btnNext.setText(R.string.done);
                        btnNext.setVisibility(View.VISIBLE);

                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        circleIndicatorMain.setViewPager(viewPagerMain);
    }

    private void getProfileDetails() {
        if (NetworkHelper.isOnline(this)) {
            int patientID = SharedPreferenceHelper.getInstance(this).getIntValue(Keys.PATIENT_ID, -1);
            String authToken = SharedPreferenceHelper.getInstance(this).getStringValue(Keys.AUTH_TOKEN, "");
            new ProfilePresenter(this, new ProfileInteractorImpl()).getProfile(patientID, authToken);
        } else {
            UIHelper.showToast(this, getString(R.string.no_internet));
        }
    }

    private void getSpecialization() {
        if (NetworkHelper.isOnline(this)) {
            int patientID = SharedPreferenceHelper.getInstance(this).getIntValue(Keys.PATIENT_ID, -1);
            String authToken = SharedPreferenceHelper.getInstance(this).getStringValue(Keys.AUTH_TOKEN, "");
            new ProfilePresenter(this, new ProfileInteractorImpl()).getSpecialization(patientID, authToken);
        } else {
            UIHelper.showToast(this, getString(R.string.no_internet));
        }
    }


    @Override
    public void onGetProfileSuccess(ProfileResponse profileResponse) {
        UIHelper.showToast(this, "Profile Success");
        if (viewPagerMain.getAdapter() != null) {
            ((ProfileSectionAdapter) viewPagerMain.getAdapter()).updateData(profileResponse);
            viewPagerMain.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void onGetProfileFailure(BaseResponse baseResponse) {

    }

    @Override
    public void onGetSpecialization(Specialization specialization)
    {
        if (viewPagerMain.getAdapter() != null) {
            ((ProfileSectionAdapter) viewPagerMain.getAdapter()).getSpecialization(specialization);
            viewPagerMain.getAdapter().notifyDataSetChanged();
        }
    }

    @OnClick({R.id.btn_next, R.id.btn_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                if (viewPagerMain.getCurrentItem() == 0)
                {
                    viewPagerMain.setCurrentItem(1);
                }else if(viewPagerMain.getCurrentItem() == 1)
                {
                    viewPagerMain.setCurrentItem(2);
                }
                break;
            case R.id.btn_skip:
                if (viewPagerMain.getCurrentItem() == 1) {
                    viewPagerMain.setCurrentItem(0);
                }else  if (viewPagerMain.getCurrentItem() == 2){
                    viewPagerMain.setCurrentItem(1);
                }
                break;
        }
    }
}
