package heal.com.healdoctor.welcome.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import heal.com.healdoctor.R;
import heal.com.healdoctor.helper.SharedPreferenceHelper;
import heal.com.healdoctor.login.view.LoginChooserActivity;
import heal.com.healdoctor.welcome.adapter.ViewPagerAdapter;

/**
 * This activity is used to show the welcome screen to the user
 */
public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.layoutDots)
    LinearLayout dotsLayout;

    @BindView(R.id.btn_skip)
    Button btnSkip;

    @BindView(R.id.btn_next)
    Button btnNext;

    private int[] layouts;

    private ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                btnNext.setVisibility(View.VISIBLE);
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.INVISIBLE);
            } else {
                // still pages are left
                btnNext.setVisibility(View.VISIBLE);
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hideStatusBar();

        setContentView(R.layout.activity_welcome);

        ButterKnife.bind(this);

        try {
            // Check if First Launch
            if (!SharedPreferenceHelper.getInstance(this).getBooleanValue(SharedPreferenceHelper.Keys.PREF_IS_FIRST_LAUNCH, true)) {
                navigateToLogin();
                finish();
            }

            setup();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to hide the status bar and make the activity fullscreen
     */
    private void hideStatusBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    /**
     * This method is used to setup the activity
     */
    private void setup() {
        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.welcome_slide1,
                R.layout.welcome_slide2,
                R.layout.welcome_slide3,
                R.layout.welcome_slide4};

        // adding bottom dots
        addBottomDots(0);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, layouts);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferenceHelper.getInstance(WelcomeActivity.this).setValue(SharedPreferenceHelper.Keys.PREF_IS_FIRST_LAUNCH, false);
                navigateToLogin();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem();

                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                    SharedPreferenceHelper.getInstance(WelcomeActivity.this).setValue(SharedPreferenceHelper.Keys.PREF_IS_FIRST_LAUNCH, false);
                    navigateToLogin();
                }
            }
        });
    }

    /**
     * Show the dots for the pager
     *
     * @param currentPage Current page
     */
    private void addBottomDots(int currentPage) {
        TextView[] dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    /**
     * Returns the index of current item
     *
     * @return Index of current item
     */
    private int getItem() {
        return viewPager.getCurrentItem() + 1;
    }

    private void navigateToLogin() {
        Intent intent = new Intent(WelcomeActivity.this, LoginChooserActivity.class);
        startActivity(intent);
        finish();
    }
}
