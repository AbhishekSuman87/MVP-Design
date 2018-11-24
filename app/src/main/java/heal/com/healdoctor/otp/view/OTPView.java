package heal.com.healdoctor.otp.view;

import heal.com.healdoctor.base.BaseMVPView;

public interface OTPView extends BaseMVPView {
    void onOTPGenerationSuccess();

    void onOTPGenerationFailure();
}
