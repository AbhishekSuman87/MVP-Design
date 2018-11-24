package heal.com.healdoctor.profile.model.presenter;


import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.profile.model.entity.ProfileResponse;
import heal.com.healdoctor.profile.model.entity.Specialization;
import heal.com.healdoctor.profile.model.interactor.ProfileInteractor;
import heal.com.healdoctor.profile.model.interactor.ProfileInteractorImpl.ProfileListener;
import heal.com.healdoctor.profile.view.ProfileView;

public class ProfilePresenter implements ProfileListener {

    private final ProfileView profileView;
    private final ProfileInteractor profileInteractor;

    public ProfilePresenter(ProfileView profileView, ProfileInteractor profileInteractor) {
        this.profileView = profileView;
        this.profileInteractor = profileInteractor;
    }

    public void getProfile(int patientID, String authToken) {
        profileInteractor.getProfile(patientID, authToken, this);
    }

    public void getSpecialization(int patientID, String authToken) {
        profileInteractor.getSpecialization(patientID, authToken, this);
    }

    @Override
    public void onGetProfileSuccess(ProfileResponse profileResponse) {
        profileView.onGetProfileSuccess(profileResponse);
    }

    @Override
    public void onGetProfileFailure(BaseResponse baseResponse) {
        profileView.onGetProfileFailure(baseResponse);
    }

    @Override
    public void onGetSpecialization(Specialization specialization) {
        profileView.onGetSpecialization(specialization);
    }
}
