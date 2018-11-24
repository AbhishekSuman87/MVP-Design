package heal.com.healdoctor.login.view;

import heal.com.healdoctor.base.BaseMVPView;
import heal.com.healdoctor.login.model.entity.LoginResponse;
import heal.com.healdoctor.network.BaseResponse;

public interface LoginView extends BaseMVPView {
    void onLoginSuccess(LoginResponse loginResponse);

    void onLoginFailure(BaseResponse errorResponse);
}
