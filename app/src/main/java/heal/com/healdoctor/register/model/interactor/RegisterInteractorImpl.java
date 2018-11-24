package heal.com.healdoctor.register.model.interactor;

import android.support.annotation.NonNull;
import android.util.Log;

import heal.com.healdoctor.helper.ErrorHelper;
import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.network.ResponseCodes;
import heal.com.healdoctor.register.model.entity.RegistrationRequest;
import heal.com.healdoctor.register.model.entity.RegistrationResponse;
import heal.com.healdoctor.register.model.service.RegisterService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterInteractorImpl implements RegisterInteractor {

    private RegisterService registerService;

    public RegisterInteractorImpl() {
        registerService = new RegisterService();
    }

    @Override
    public void register(RegistrationRequest jsonObjectUser, final RegisterListener registerListener) {

        registerService.getRegisterAPI().register(jsonObjectUser).enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegistrationResponse> call, @NonNull Response<RegistrationResponse> response) {
                 if (response.isSuccessful()) {
                    RegistrationResponse registrationResponse = response.body();

                    if (registrationResponse != null && registrationResponse.getResponseType().equals(ResponseCodes.SUCCESS)) {
                        registerListener.onRegistrationSuccess(registrationResponse);
                    } else {
                        registerListener.onRegistrationFailure(ErrorHelper.parseError(response));
                    }
                } else {
                    registerListener.onRegistrationFailure(ErrorHelper.parseError(response));
                }
            }

            @Override
            public void onFailure(@NonNull Call<RegistrationResponse> call, @NonNull Throwable t) {
                Log.d("TAG1","onFailure=="+call.request());
                registerListener.onRegistrationFailure(ErrorHelper.parseError(null));
            }
        });
    }

    public interface RegisterListener {
        void onRegistrationSuccess(RegistrationResponse registrationResponse);

        void onRegistrationFailure(BaseResponse errorResponse);
    }
}
