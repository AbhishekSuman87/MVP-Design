package heal.com.healdoctor.register.view;

import heal.com.healdoctor.base.BaseMVPView;
import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.profile.model.entity.Specialization;
import heal.com.healdoctor.register.model.entity.RegistrationResponse;

public interface RegisterView extends BaseMVPView {
    void onRegistrationSuccess(RegistrationResponse registrationResponse);

    void onRegistrationFailure(BaseResponse errorResponse);


}
