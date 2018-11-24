package heal.com.healdoctor.register.presenter;

import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.register.model.entity.RegistrationRequest;
import heal.com.healdoctor.register.model.entity.RegistrationResponse;
import heal.com.healdoctor.register.model.interactor.RegisterInteractor;
import heal.com.healdoctor.register.model.interactor.RegisterInteractorImpl;
import heal.com.healdoctor.register.view.RegisterView;

public class RegisterPresenter implements RegisterInteractorImpl.RegisterListener {
    private final RegisterView registerView;
    private final RegisterInteractor registerInteractor;

    public RegisterPresenter(RegisterView registerView, RegisterInteractor registerInteractor) {

        this.registerView = registerView;
        this.registerInteractor = registerInteractor;
    }

    public void register(RegistrationRequest jsonObject) {
        registerView.showProgress();
         registerInteractor.register(jsonObject, this);
    }

    @Override
    public void onRegistrationSuccess(RegistrationResponse registrationResponse) {
        registerView.onRegistrationSuccess(registrationResponse);
    }

    @Override
    public void onRegistrationFailure(BaseResponse errorResponse) {
        registerView.onRegistrationFailure(errorResponse);
    }
}
