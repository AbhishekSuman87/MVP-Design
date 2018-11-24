package heal.com.healdoctor.register.model.service;

import heal.com.healdoctor.register.model.entity.RegistrationRequest;
import heal.com.healdoctor.register.model.entity.RegistrationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterAPI {

    @POST("registration/add")
    Call<RegistrationResponse> register(@Body RegistrationRequest jsonObjectUser);
}
