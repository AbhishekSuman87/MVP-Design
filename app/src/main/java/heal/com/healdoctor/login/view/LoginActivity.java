package heal.com.healdoctor.login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import heal.com.healdoctor.R;
import heal.com.healdoctor.dashboard.view.activity.NavigationActivity;
import heal.com.healdoctor.helper.AppConstants;
import heal.com.healdoctor.helper.GlobalVariables;
import heal.com.healdoctor.helper.NetworkHelper;
import heal.com.healdoctor.helper.SharedPreferenceHelper;
import heal.com.healdoctor.helper.UIHelper;
import heal.com.healdoctor.helper.ValidationUtils;
import heal.com.healdoctor.login.model.entity.LoginRequest;
import heal.com.healdoctor.login.model.entity.LoginResponse;
import heal.com.healdoctor.login.model.interactor.LoginInteractorImpl;
import heal.com.healdoctor.login.presenter.LoginPresenter;
import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.otp.view.MobileNumberActivity;
import heal.com.healdoctor.profile.view.ProfileActivity;

public class LoginActivity extends AppCompatActivity implements OnClickListener, LoginView {

    @BindView(R.id.medtEmailID)
    EditText medtEmailID;
    @BindView(R.id.medtPassword)
    EditText medtPassword;
    @BindView(R.id.imageView9)
    ImageView imageView9;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.btnLogin)
    TextView btnLogin;
    @BindView(R.id.textViewOTP)
    TextView textViewOTP;
    private Context mContext = LoginActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        setup();
    }

    private void setup() {

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @OnClick(R.id.btnLogin)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                int loginType = -1;
                String loginText = medtEmailID.getText().toString();
                if (loginText.isEmpty()) {
                    UIHelper.showToast(mContext, mContext.getString(R.string.email_phone_is_missing));
                    return;
                }
                if (medtPassword.getText().toString().isEmpty()) {
                    UIHelper.showToast(mContext, mContext.getString(R.string.password_is_missing));
                    return;
                }

                if (loginText.contains("@") && ValidationUtils.validateEmailID(loginText)) {
                    loginType = 0;
                } else if (loginText.length() == 10 && TextUtils.isDigitsOnly(loginText)) {
                    loginType = 1;
                } else if (loginType == -1) {
                    UIHelper.showDialog(mContext, 0, "Enter proper login credentails.", null);
                    return;

                }


                LoginRequest loginRequest = new LoginRequest();
                if (loginType == 0) {
                    loginRequest.setEmailId(loginText);
                    loginRequest.setMobileNo("");
                } else {
                    loginRequest.setEmailId("");
                    loginRequest.setMobileNo(loginText);
                }
                loginRequest.setModule(AppConstants.APP_CLIENT_TYPE);
                loginRequest.setOtp("");
                loginRequest.setAccount(1);
                loginRequest.setUsername("");
                loginRequest.setPassword(medtPassword.getText().toString());
                callLogin(loginRequest, loginType);

                break;
        }
    }

    private void callLogin(LoginRequest loginRequest, int loginType) {
        if (NetworkHelper.isOnline(mContext)) {
            new LoginPresenter(this, new LoginInteractorImpl()).login(loginRequest, loginType);
        } else {
            Toast.makeText(mContext, R.string.no_internet, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoginSuccess(LoginResponse loginResponse) {
        SharedPreferenceHelper.getInstance(mContext).setValue(SharedPreferenceHelper.Keys.AUTH_TOKEN, loginResponse.getData().getToken());
        SharedPreferenceHelper.getInstance(mContext).setValue(SharedPreferenceHelper.Keys.PATIENT_ID, loginResponse.getData().getIdValue());
        SharedPreferenceHelper.getInstance(mContext).setValue(SharedPreferenceHelper.Keys.KEY_LOGIN, true);

        UIHelper.showToast(this, "Login successful");

        if (loginResponse.getStatus() != null) {
            if (loginResponse.getStatus().equals(AppConstants.STATUS_INACTIVE)) {
                SharedPreferenceHelper.getInstance(LoginActivity.this).setValue(SharedPreferenceHelper.Keys.STATUS_INACTIVE, false);
                Intent intent = new Intent(mContext, ProfileActivity.class);
                startActivity(intent);
            } else {
                SharedPreferenceHelper.getInstance(mContext).setValue(SharedPreferenceHelper.Keys.STATUS_INACTIVE, true);
                Intent intent = new Intent(mContext, ProfileActivity.class);
                startActivity(intent);
            }
        } else {
            UIHelper.showDialog(mContext, 0, "Something went wrong", null);
        }

    }

    @Override
    public void onLoginFailure(BaseResponse errorResponse) {
        try {
            UIHelper.showDialog(mContext, 0, "" + errorResponse.getErrors().get(0).getErrorDesc(),null);
        } catch (Exception e) {
            UIHelper.showDialog(mContext, 0, "Something went wrong,Please try again",null);
        }

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @OnClick(R.id.textViewOTP)
    public void onViewClicked()
    {
        GlobalVariables.otpType=2;
        startActivity(MobileNumberActivity.class);
    }

    void startActivity(Class class1) {
        // startActivity(new Intent(mContext,class1));
        Intent intent = new Intent(mContext, class1);
        mContext.startActivity(intent);
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }
}
