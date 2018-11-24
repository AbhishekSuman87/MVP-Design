package heal.com.healdoctor.login.presenter;

import heal.com.healdoctor.login.model.entity.LoginRequest;
import heal.com.healdoctor.login.model.entity.LoginResponse;
import heal.com.healdoctor.login.model.interactor.LoginInteractor;
import heal.com.healdoctor.login.model.interactor.LoginInteractorImpl;
import heal.com.healdoctor.login.view.LoginView;
import heal.com.healdoctor.network.BaseResponse;

public class LoginPresenter implements LoginInteractorImpl.LoginListener {
    private final LoginView loginView;
    private final LoginInteractor loginInteractor;

    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {

        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void login(LoginRequest jsonObject, int loginType) {
        loginView.showProgress();

        loginInteractor.Login(jsonObject, this,loginType);
    }

    @Override
    public void onLoginSuccess(LoginResponse loginResponse) {
        loginView.onLoginSuccess(loginResponse);
    }

    @Override
    public void onLoginFailure(BaseResponse errorResponse) {
        loginView.onLoginFailure(errorResponse);
    }
}
