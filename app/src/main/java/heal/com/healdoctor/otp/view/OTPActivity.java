package heal.com.healdoctor.otp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import heal.com.healdoctor.R;
import heal.com.healdoctor.helper.GlobalVariables;
import heal.com.healdoctor.helper.KeyExtras;
import heal.com.healdoctor.helper.NetworkHelper;
import heal.com.healdoctor.otp.model.interactor.OTPInteractorImpl;
import heal.com.healdoctor.otp.presenter.OTPPresenter;
import heal.com.healdoctor.profile.view.ProfileActivity;
import heal.com.healdoctor.register.view.RegisterActivity;

public class OTPActivity extends AppCompatActivity implements View.OnClickListener, OTPView {
    @BindView(R.id.tvResendOTP)
    TextView mtvReSendOtp;
    @BindView(R.id.timeout)
    TextView mTvTimeout;
    @BindView(R.id.progressBarToday)
    ProgressBar mProgressbar;
    CountDownTimer countDownTimer;
    @BindView(R.id.edtOTP)
    EditText edtOTP;
    private Context mContext = OTPActivity.this;
    private String strMob;
    private OTPPresenter otpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_otp);

        ButterKnife.bind(this);

        if (getIntent().getStringExtra(KeyExtras.KEY_MOBILE_NO) != null) {
            strMob = getIntent().getStringExtra(KeyExtras.KEY_MOBILE_NO);
        }

        setup();
    }

    private void startTimer(final int minutes) {
        countDownTimer = new CountDownTimer(minutes * 1000, 500) {
            // 500 means, onTick function will be called at every 500 milliseconds

            @Override
            public void onTick(long leftTimeInMilliseconds) {
                long seconds = leftTimeInMilliseconds / 1000;
                mProgressbar.setProgress((int) seconds);
                mTvTimeout.setText(String.format("%02d", seconds % 60));
            }

            @Override
            public void onFinish() {
                if (mTvTimeout.getText().equals("00")) {
                    mTvTimeout.setText("STOP");
                    mtvReSendOtp.setVisibility(View.VISIBLE);
                    mtvReSendOtp.setEnabled(true);
                } else {
                    mTvTimeout.setText("30");
                    mProgressbar.setProgress(60 * minutes);
                }
            }
        }.start();

    }

    /*
    initcontrollers: initialisation of all controllers
     */
    private void setup() {
        otpPresenter = new OTPPresenter(this, new OTPInteractorImpl());

        mtvReSendOtp.setEnabled(false);
        mtvReSendOtp.setVisibility(View.GONE);

        startTimer(30);

        edtOTP.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 4) {
                    if(GlobalVariables.otpType==1) {
                        Intent intent = new Intent(mContext, RegisterActivity.class);
                        intent.putExtra(KeyExtras.KEY_MOBILE_NO, strMob);
                        intent.putExtra(KeyExtras.KEY_OTP, edtOTP.getText().toString());
                        startActivity(intent);
                        finish();

                    }else if(GlobalVariables.otpType==2) {
                        Intent intent = new Intent(mContext, ProfileActivity.class);
                        intent.putExtra(KeyExtras.KEY_MOBILE_NO, strMob);
                        intent.putExtra(KeyExtras.KEY_OTP, edtOTP.getText().toString());
                        startActivity(intent);
                    }
                }
            }
        });
    }

    @OnClick(R.id.tvResendOTP)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvResendOTP:
                generateOTP(strMob);
                mtvReSendOtp.setVisibility(View.GONE);
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
            Toast.makeText(mContext, R.string.no_internet, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onOTPGenerationSuccess() {

    }

    @Override
    public void onOTPGenerationFailure() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}

