package heal.com.healdoctor.register.model.interactor;

import heal.com.healdoctor.register.model.entity.RegistrationRequest;

public interface RegisterInteractor {
    void register(RegistrationRequest jsonObjectUser, RegisterInteractorImpl.RegisterListener registerListener);
}
