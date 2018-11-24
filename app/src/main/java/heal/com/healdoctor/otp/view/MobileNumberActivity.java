package heal.com.healdoctor.otp.view;

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
import heal.com.healdoctor.helper.KeyExtras;
import heal.com.healdoctor.helper.NetworkHelper;
import heal.com.healdoctor.helper.SharedPreferenceHelper;
import heal.com.healdoctor.helper.UIHelper;
import heal.com.healdoctor.otp.model.interactor.OTPInteractorImpl;
import heal.com.healdoctor.otp.presenter.OTPPresenter;

/**
 * This activity is used to get the user's mobile number and generate OTP
 */
public class MobileNumberActivity extends AppCompatActivity implements View.OnClickListener, OTPView {

    @BindView(R.id.edtMobileNo)
    EditText medtMobileNo;

    private Context context = MobileNumberActivity.this;

    private OTPPresenter otpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mobile_number);

        ButterKnife.bind(this);

        setup();
    }

    private void setup() {
        otpPresenter = new OTPPresenter(this, new OTPInteractorImpl());
    }

    @OnClick(R.id.tvSendOtp)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSendOtp:
                if (medtMobileNo.getText().length() < 10) {
                    UIHelper.showToast(context, "Enter Valid Mobile No");
                    return;
                }
                SharedPreferenceHelper.getInstance(this).setValue(SharedPreferenceHelper.Keys.PREF_MOBILE_NUMBER, medtMobileNo.getText().toString());
                generateOTP(medtMobileNo.getText().toString());
                break;
        }
    }

    /**
     * This method is used to call the Generate API service
     *
     * @param mobileStr Mobile number
     */
    private void generateOTP(String mobileStr) {
        if (NetworkHelper.isOnline(this)) {
            otpPresenter.generateOTP(mobileStr);
        } else {
            Toast.makeText(context, R.string.no_internet, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onOTPGenerationSuccess() {
        Intent intent = new Intent(context, OTPActivity.class);
        intent.putExtra(KeyExtras.KEY_MOBILE_NO, medtMobileNo.getText().toString());
        startActivity(intent);
        finish();

        UIHelper.showToast(this, "OTP Generation Success");
    }

    /*@Override
    public void onOTPGenerationExistingCustomer(Map otpResponse, boolean active) {
        String jsonData = otpResponse == null ? null : new Gson().toJson(otpResponse);
        SharedPreferenceHelper.getInstance(this).setValue(SharedPreferenceHelper.Keys.KEY_MOBILE_MODEL, jsonData);

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(KeyExtras.KEY_MOBILE_NO, medtMobileNo.getText().toString());
        startActivity(intent);
    }*/

    @Override
    public void onOTPGenerationFailure() {
        UIHelper.showDialog(context, 0, "OTP generation failed", new UIHelper.AlertDialogListener() {
            @Override
            public void onPositiveButtonClick() {
                finish();
            }

            @Override
            public void onNegativeButtonClick() {

            }
        });
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {

    }
}
