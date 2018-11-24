package heal.com.healdoctor.login.model.service;

import heal.com.healdoctor.login.model.entity.LoginRequest;
import heal.com.healdoctor.login.model.entity.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginAPI {

    @POST("login/email/")
    Call<LoginResponse> loginEmail(@Body LoginRequest jsonObjectUser);

    @POST("login/mobile/")
    Call<LoginResponse> loginPhone(@Body LoginRequest jsonObjectUser);
}
