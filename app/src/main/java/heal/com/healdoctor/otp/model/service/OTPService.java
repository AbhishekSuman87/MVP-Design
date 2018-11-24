package heal.com.healdoctor.otp.model.service;

import heal.com.healdoctor.network.RetrofitInstance;

public class OTPService {
    /**
     * This method creates a new instance of the API interface.
     *
     * @return The API interface
     */
    public OTPApi getOTPGenerateAPI() {
        return RetrofitInstance.getRetrofitInstance().create(OTPApi.class);
    }
}
