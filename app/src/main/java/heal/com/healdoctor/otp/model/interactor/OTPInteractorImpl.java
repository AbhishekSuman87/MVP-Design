package heal.com.healdoctor.otp.model.interactor;

import android.support.annotation.NonNull;

import heal.com.healdoctor.helper.ErrorHelper;
import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.otp.model.interactor.OTPInteractor;
import heal.com.healdoctor.otp.model.service.OTPService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPInteractorImpl implements OTPInteractor {

    private OTPService otpService;

    public OTPInteractorImpl() {
        otpService = new OTPService();
    }

    @Override
    public void generateOTP(String mobileNumber, final OTPListener otpListener) {
        otpService.getOTPGenerateAPI().generateOTP(mobileNumber).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(@NonNull Call<Object> call, @NonNull Response<Object> response) {
                if (response.isSuccessful()) {
                    otpListener.onOTPGenerationSuccess();
                } else {
                    otpListener.onOTPGenerationFailure(ErrorHelper.parseError(response));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Object> call, @NonNull Throwable t) {
                otpListener.onOTPGenerationFailure(ErrorHelper.parseError(null));
            }
        });
    }

    public interface OTPListener {
        void onOTPGenerationSuccess();

        void onOTPGenerationFailure(BaseResponse baseResponse);
    }
}
