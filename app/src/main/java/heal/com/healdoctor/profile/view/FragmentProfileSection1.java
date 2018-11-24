package heal.com.healdoctor.profile.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import heal.com.healdoctor.R;
import heal.com.healdoctor.profile.model.entity.ProfileResponse;

public class FragmentProfileSection1 extends Fragment {

    @BindView(R.id.tvDOB)
    TextView tvBdate;
    @BindView(R.id.civProfile)
    CircleImageView civProfile;
    @BindView(R.id.ivEditProfileImg)
    ImageView ivEditProfileImg;
    @BindView(R.id.rlProfile)
    RelativeLayout rlProfile;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.edtFname)
    EditText edtFname;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.edtLname)
    EditText edtLname;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.rbMale)
    RadioButton rbMale;
    @BindView(R.id.rbFemale)
    RadioButton rbFemale;
    @BindView(R.id.rgroup)
    RadioGroup rgroup;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.textViewadd1)
    TextView textViewadd1;
    @BindView(R.id.edtAddress1)
    EditText edtAddress1;
    @BindView(R.id.textViewAdd2)
    TextView textViewAdd2;
    @BindView(R.id.edtAddress2)
    EditText edtAddress2;
    @BindView(R.id.textViewpin)
    TextView textViewpin;
    @BindView(R.id.edtPincode)
    EditText edtPincode;
    @BindView(R.id.AutoCountry)
    EditText AutoCountry;
    @BindView(R.id.AutoState)
    EditText AutoState;
    @BindView(R.id.textViewDist)
    TextView textViewDist;
    @BindView(R.id.AutoDistrict)
    EditText AutoDistrict;
    @BindView(R.id.textViewcity)
    TextView textViewcity;
    @BindView(R.id.AutoCity)
    EditText AutoCity;
    @BindView(R.id.mLinearLayoutAdress)
    LinearLayout mLinearLayoutAdress;
    @BindView(R.id.nestScroll)
    NestedScrollView nestScroll;

    public FragmentProfileSection1() {
        // Required empty public constructor
    }

    public static FragmentProfileSection1 newInstance(ProfileResponse profileResponse) {
        return new FragmentProfileSection1();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_profile_section_one, container, false);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    public void updateData(ProfileResponse profileResponse) {
        if (profileResponse != null) {

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
