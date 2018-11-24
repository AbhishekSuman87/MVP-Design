package heal.com.healdoctor.profile.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import heal.com.healdoctor.R;
import heal.com.healdoctor.profile.model.entity.ProfileResponse;

public class FragmentProfileSection3 extends Fragment {

    @BindView(R.id.edtLocation)
    TextView edtLocation;

    public FragmentProfileSection3() {
        // Required empty public constructor
    }

    public static FragmentProfileSection3 newInstance(ProfileResponse profileResponse) {
        return new FragmentProfileSection3();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_profile_section_three, container, false);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    public void updateData(ProfileResponse profileResponse) {
        if (profileResponse != null) {
            edtLocation.setText(profileResponse.getData().getPatientAddress().getCityName() + ", " +
                    profileResponse.getData().getPatientAddress().getStateName() + ", " +
                    profileResponse.getData().getPatientAddress().getCountryName());
        }
    }
}
