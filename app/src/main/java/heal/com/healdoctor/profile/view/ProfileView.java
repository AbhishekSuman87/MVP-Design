package heal.com.healdoctor.profile.view;


import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.profile.model.entity.ProfileResponse;
import heal.com.healdoctor.profile.model.entity.Specialization;

public interface ProfileView {
    void onGetProfileSuccess(ProfileResponse profileResponse);

    void onGetProfileFailure(BaseResponse baseResponse);

    void onGetSpecialization(Specialization specialization);
}
