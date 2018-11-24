package heal.com.healdoctor.profile.model.interactor;

import android.support.annotation.NonNull;

import heal.com.healdoctor.helper.ErrorHelper;
import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.profile.model.entity.ProfileResponse;
import heal.com.healdoctor.profile.model.entity.Specialization;
import heal.com.healdoctor.profile.model.service.ProfileService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileInteractorImpl implements ProfileInteractor {

    private ProfileService profileService;

    public ProfileInteractorImpl() {
        profileService = new ProfileService();
    }

    @Override
    public void getProfile(int patientID, String authToken, final ProfileListener profileListener) {
        profileService.getProfileAPI().getProfile(patientID, authToken).enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProfileResponse> call, @NonNull Response<ProfileResponse> response) {
                if (response.isSuccessful()) {
                    profileListener.onGetProfileSuccess(response.body());
                } else {
                    profileListener.onGetProfileFailure(ErrorHelper.parseError(response));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ProfileResponse> call, @NonNull Throwable t) {

            }
        });
    }

    @Override
    public void getSpecialization(int patientID, String authToken, final ProfileListener profileListener) {
        profileService.getProfileAPI().getSpecialization(patientID, authToken).enqueue(new Callback<Specialization>() {
            @Override
            public void onResponse(Call<Specialization> call, Response<Specialization> response) {
                if (response.isSuccessful()) {
                    profileListener.onGetSpecialization(response.body());
                } else {
                    profileListener.onGetProfileFailure(ErrorHelper.parseError(response));
                }
            }

            @Override
            public void onFailure(Call<Specialization> call, Throwable t) {

            }
        });
    }

    public interface ProfileListener {
        void onGetProfileSuccess(ProfileResponse profileResponse);

        void onGetProfileFailure(BaseResponse baseResponse);

        void onGetSpecialization(Specialization specialization);
    }
}
