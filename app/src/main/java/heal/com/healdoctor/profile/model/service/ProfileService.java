package heal.com.healdoctor.profile.model.service;


import heal.com.healdoctor.network.RetrofitInstance;

public class ProfileService {
    public GetProfileAPI getProfileAPI() {
        return RetrofitInstance.getRetrofitInstance().create(GetProfileAPI.class);
    }
}
