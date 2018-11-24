package heal.com.healdoctor.otp.presenter;

import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.otp.model.interactor.OTPInteractor;
import heal.com.healdoctor.otp.model.interactor.OTPInteractorImpl;
import heal.com.healdoctor.otp.view.OTPView;

public class OTPPresenter implements OTPInteractorImpl.OTPListener {
    private final OTPView otpView;
    private final OTPInteractor otpInteractor;

    public OTPPresenter(OTPView otpView, OTPInteractor otpInteractor) {

        this.otpView = otpView;
        this.otpInteractor = otpInteractor;
    }

    public void generateOTP(String mobileNumber) {
        otpView.showProgress();

        otpInteractor.generateOTP(mobileNumber, this);
    }

    @Override
    public void onOTPGenerationSuccess() {
        otpView.hideProgress();
        otpView.onOTPGenerationSuccess();
    }

    @Override
    public void onOTPGenerationFailure(BaseResponse baseResponse) {
        otpView.hideProgress();
        otpView.onOTPGenerationFailure();
    }
}
