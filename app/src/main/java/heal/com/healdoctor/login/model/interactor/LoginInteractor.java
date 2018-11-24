package heal.com.healdoctor.login.model.interactor;

import heal.com.healdoctor.login.model.entity.LoginRequest;
import heal.com.healdoctor.login.model.interactor.LoginInteractorImpl.LoginListener;

public interface LoginInteractor {
    void Login(LoginRequest jsonObject, LoginListener loginListener, int loginType);
}
