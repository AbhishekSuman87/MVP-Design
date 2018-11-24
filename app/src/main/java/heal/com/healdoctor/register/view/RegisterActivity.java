package heal.com.healdoctor.register.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import heal.com.healdoctor.R;
import heal.com.healdoctor.helper.AppConstants;
import heal.com.healdoctor.helper.KeyExtras;
import heal.com.healdoctor.helper.NetworkHelper;
import heal.com.healdoctor.helper.SharedPreferenceHelper;
import heal.com.healdoctor.helper.UIHelper;
import heal.com.healdoctor.login.view.LoginActivity;
import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.profile.model.entity.Specialization;
import heal.com.healdoctor.register.model.entity.RegistrationRequest;
import heal.com.healdoctor.register.model.entity.RegistrationResponse;
import heal.com.healdoctor.register.model.interactor.RegisterInteractorImpl;
import heal.com.healdoctor.register.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, RegisterView {

    @BindView(R.id.medtEmailID)
    EditText medtEmailID;
    @BindView(R.id.medtPassword)
    EditText medtPassword;
    @BindView(R.id.medtConfirmPassword)
    EditText medtConfirmPassword;
    @BindView(R.id.medtMobileNumber)
    EditText medtMobileNumber;
    private Context mContext = RegisterActivity.this;
    private String strOTP = "";
    private String strMobileNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        setup();
    }

    private void setup() {
        medtEmailID = findViewById(R.id.medtEmailID);
        medtPassword = findViewById(R.id.medtPassword);

        if (getIntent().getStringExtra(KeyExtras.KEY_OTP) != null) {
            strOTP = getIntent().getStringExtra(KeyExtras.KEY_OTP);
        }

        if (getIntent().getStringExtra(KeyExtras.KEY_MOBILE_NO) != null) {
            strMobileNumber = getIntent().getStringExtra(KeyExtras.KEY_MOBILE_NO);
        }

        medtMobileNumber.setText(strMobileNumber);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @OnClick(R.id.btnRegister)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                if (medtPassword.getText().toString().isEmpty()) {
                    UIHelper.showToast(mContext, mContext.getString(R.string.password_is_missing));
                    return;
                } else if (medtConfirmPassword.toString().isEmpty()) {
                    UIHelper.showToast(mContext, mContext.getString(R.string.confirm_password_is_missing));
                    return;
                } else if (!medtPassword.getText().toString().equals(medtConfirmPassword.getText().toString())) {
                    UIHelper.showToast(mContext, mContext.getString(R.string.password_not_match));
                    return;
                }

//                    JSONObject jsonObject = new JSONObject();
//                    jsonObject.put(RequestKeys.KEY_REGI_EMAIL, medtEmailID.getText().toString());
//                    jsonObject.put(RequestKeys.KEY_REGI_MOB, strMobileNumber);
//                    jsonObject.put(RequestKeys.KEY_REGI_MODEL, AppConstants.APP_CLIENT_TYPE);
//                    jsonObject.put(RequestKeys.KEY_REGI_OTP, strOTP);
//                    jsonObject.put(RequestKeys.KEY_REGI_PASS, medtPassword.getText().toString());
///                   jsonObject.put(RequestKeys.KEY_REGI_ACC, AppConstants.APP_ACCOUNT_ID);

                RegistrationRequest registrationRequest = new RegistrationRequest();
                registrationRequest.setEmailId(medtEmailID.getText().toString());
                registrationRequest.setMobileNo(strMobileNumber);
                registrationRequest.setModule(AppConstants.APP_CLIENT_TYPE);
                registrationRequest.setOtp(strOTP);
                registrationRequest.setPassword(medtPassword.getText().toString());

                callRegister(registrationRequest);
                break;
        }
    }

    private void callRegister(RegistrationRequest jsonObjectUser) {
        if (NetworkHelper.isOnline(mContext)) {
            new RegisterPresenter(this, new RegisterInteractorImpl()).register(jsonObjectUser);
        } else {
            Toast.makeText(mContext, R.string.no_internet, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRegistrationSuccess(RegistrationResponse registrationResponse) {
        SharedPreferenceHelper.getInstance(mContext).setValue(SharedPreferenceHelper.Keys.AUTH_TOKEN, registrationResponse.getData().getMap().getViewState());
        SharedPreferenceHelper.getInstance(mContext).setValue(SharedPreferenceHelper.Keys.KEY_LOGIN, true);

        if (registrationResponse.getStatus() != null) {
            if (registrationResponse.getStatus().equals(AppConstants.STATUS_INACTIVE)) {
                SharedPreferenceHelper.getInstance(this).setValue(SharedPreferenceHelper.Keys.STATUS_INACTIVE, false);
            } else {
                SharedPreferenceHelper.getInstance(mContext).setValue(SharedPreferenceHelper.Keys.STATUS_INACTIVE, true);
            }

            UIHelper.showDialog(mContext, 0, "Registration successful. Please use current credentials to log in.", new UIHelper.AlertDialogListener() {
                @Override
                public void onPositiveButtonClick() {
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onNegativeButtonClick() {

                }
            });
        } else {
            UIHelper.showToast(mContext, "Something went wrong,Please try again");
        }
    }

    @Override
    public void onRegistrationFailure(BaseResponse errorResponse) {
        try{
            UIHelper.showDialog(mContext, 0,""+errorResponse.getErrors().get(0).getErrorDesc(),null);
        }catch (Exception e)
        {
            UIHelper.showDialog(mContext, 0,"Something went wrong,Please try again", null);
        }

    }



    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
