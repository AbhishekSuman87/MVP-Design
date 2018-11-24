package heal.com.healdoctor.profile.view;

        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v4.widget.NestedScrollView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import butterknife.BindView;
        import butterknife.ButterKnife;
        import de.hdodenhof.circleimageview.CircleImageView;
        import heal.com.healdoctor.R;
        import heal.com.healdoctor.profile.model.entity.ProfileResponse;
        import heal.com.healdoctor.profile.model.entity.Specialization;

public class FragmentProfileSection2 extends Fragment {


    @BindView(R.id.civProfile)
    CircleImageView civProfile;
    @BindView(R.id.ivEditProfileImg)
    ImageView ivEditProfileImg;
    @BindView(R.id.rlProfile)
    RelativeLayout rlProfile;
    @BindView(R.id.edtYearExperience)
    EditText edtYearExperience;
    @BindView(R.id.edtSpecialisation)
    EditText edtSpecialisation;
    @BindView(R.id.tvMobileNumber)
    TextView tvMobileNumber;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.tvEmailAddress)
    TextView tvEmailAddress;
    @BindView(R.id.nestScroll)
    NestedScrollView nestScroll;

    public FragmentProfileSection2() {
        // Required empty public constructor
    }

    public static FragmentProfileSection2 newInstance(ProfileResponse profileResponse) {
        return new FragmentProfileSection2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_profile_section_two, container, false);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    public void updateData(ProfileResponse profileResponse, Specialization specialization) {
        if (specialization != null) {
            edtSpecialisation.setText(specialization.getData().get(0).getSpecializationId().getSpecializationName());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
