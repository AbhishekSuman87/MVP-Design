package heal.com.healdoctor.profile.model.service;


import heal.com.healdoctor.profile.model.entity.ProfileResponse;
import heal.com.healdoctor.profile.model.entity.Specialization;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface GetProfileAPI {
    @GET("physician/{patientID}")
    Call<ProfileResponse> getProfile(@Path("patientID") int patientID, @Header("Authorization") String token);

    @GET("physician/specialization/{patientID}")
    Call<Specialization> getSpecialization(@Path("patientID") int patientID, @Header("Authorization") String token);
}
