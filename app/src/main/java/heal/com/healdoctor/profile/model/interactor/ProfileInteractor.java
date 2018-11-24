package heal.com.healdoctor.profile.model.interactor;

import heal.com.healdoctor.profile.model.presenter.ProfilePresenter;

public interface ProfileInteractor {
    void getProfile(int patientID, String authToken, ProfileInteractorImpl.ProfileListener profileListener);

    void getSpecialization(int patientID, String authToken, ProfileInteractorImpl.ProfileListener profilePresenter);
}
