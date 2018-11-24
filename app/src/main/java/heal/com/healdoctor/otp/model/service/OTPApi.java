package heal.com.healdoctor.otp.model.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OTPApi {
    @GET("login/otp/generate/{mobile}/PHYSICIAN")
    Call<Object> generateOTP(@Path("mobile") String mobile);
}
