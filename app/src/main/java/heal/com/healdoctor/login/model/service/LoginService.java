package heal.com.healdoctor.login.model.service;

import heal.com.healdoctor.network.RetrofitInstance;

public class LoginService {
    /**
     * This method creates a new instance of the API interface.
     *
     * @return The API interface
     */
    public LoginAPI getLoginAPI() {
        return RetrofitInstance.getRetrofitInstance().create(LoginAPI.class);
    }
}
