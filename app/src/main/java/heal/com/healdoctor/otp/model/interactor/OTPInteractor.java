package heal.com.healdoctor.otp.model.interactor;

public interface OTPInteractor {
    void generateOTP(String mobileNumber, OTPInteractorImpl.OTPListener otpListener);
}
