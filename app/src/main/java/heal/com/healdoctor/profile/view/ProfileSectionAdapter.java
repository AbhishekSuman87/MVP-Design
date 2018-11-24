package heal.com.healdoctor.profile.view;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import heal.com.healdoctor.profile.model.entity.ProfileResponse;
import heal.com.healdoctor.profile.model.entity.Specialization;

public class ProfileSectionAdapter extends FragmentPagerAdapter {
    private ProfileResponse profileResponse;
    private Specialization specialization;

    public ProfileSectionAdapter(FragmentManager fm, ProfileResponse profileResponse) {
        super(fm);
        this.profileResponse = profileResponse;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return FragmentProfileSection1.newInstance(profileResponse);

            case 1:
                return FragmentProfileSection2.newInstance(profileResponse);
            case 2:
                return FragmentProfileSection3.newInstance(profileResponse);

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (object instanceof FragmentProfileSection1) {
            FragmentProfileSection1 fragmentProfileSection1 = (FragmentProfileSection1) object;
            fragmentProfileSection1.updateData(profileResponse);
        } else if (object instanceof FragmentProfileSection2) {
            FragmentProfileSection2 fragmentProfileSection2 = (FragmentProfileSection2) object;
            fragmentProfileSection2.updateData(profileResponse,specialization);
        }else {
            FragmentProfileSection3 fragmentProfileSection2 = (FragmentProfileSection3) object;
            fragmentProfileSection2.updateData(profileResponse);
        }
        return POSITION_NONE;
    }

    public void updateData(ProfileResponse profileResponse) {
        this.profileResponse = profileResponse;
    }

    public void getSpecialization(Specialization specialization) {
        this.specialization=specialization;
    }
}
