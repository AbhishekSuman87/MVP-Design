package heal.com.healdoctor.login.model.interactor;

import android.support.annotation.NonNull;
import android.util.Log;

import heal.com.healdoctor.helper.ErrorHelper;
import heal.com.healdoctor.login.model.entity.LoginRequest;
import heal.com.healdoctor.login.model.entity.LoginResponse;
import heal.com.healdoctor.login.model.service.LoginService;
import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.network.ResponseCodes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractorImpl implements LoginInteractor {

    private LoginService loginService;

    public LoginInteractorImpl() {
        loginService = new LoginService();
    }

    @Override
    public void Login(LoginRequest jsonObjectUser, final LoginListener loginListener, int loginType) {


        if(loginType==0) {
            loginService.getLoginAPI().loginEmail(jsonObjectUser).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                    Log.d("TAG1", "response.isSuccessful()==" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        LoginResponse registrationResponse = response.body();

                        if (registrationResponse != null && registrationResponse.getResponseType().equals(ResponseCodes.SUCCESS)) {
                            loginListener.onLoginSuccess(registrationResponse);
                        } else {
                            loginListener.onLoginFailure(ErrorHelper.parseError(response));
                        }
                    } else {
                        loginListener.onLoginFailure(ErrorHelper.parseError(response));
                    }
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                    loginListener.onLoginFailure(ErrorHelper.parseError(null));
                }
            });
        }else if(loginType==1)
        {
            loginService.getLoginAPI().loginPhone(jsonObjectUser).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                    Log.d("TAG1","response.isSuccessful()=="+response.isSuccessful());
                    if (response.isSuccessful()) {
                        LoginResponse registrationResponse = response.body();

                        if (registrationResponse != null && registrationResponse.getResponseType().equals(ResponseCodes.SUCCESS)) {
                            loginListener.onLoginSuccess(registrationResponse);
                        } else {
                            loginListener.onLoginFailure(ErrorHelper.parseError(response));
                        }
                    } else {
                        loginListener.onLoginFailure(ErrorHelper.parseError(response));
                    }
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                    loginListener.onLoginFailure(ErrorHelper.parseError(null));
                }
            });
        }
    }

    public interface LoginListener {
        void onLoginSuccess(LoginResponse registrationResponse);

        void onLoginFailure(BaseResponse errorResponse);
    }
}
