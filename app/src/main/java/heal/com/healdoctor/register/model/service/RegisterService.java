package heal.com.healdoctor.register.model.service;

import heal.com.healdoctor.network.RetrofitInstance;

public class RegisterService {
    /**
     * This method creates a new instance of the API interface.
     *
     * @return The API interface
     */
    public RegisterAPI getRegisterAPI() {
        return RetrofitInstance.getRetrofitInstance().create(RegisterAPI.class);
    }
}
