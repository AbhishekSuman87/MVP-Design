package heal.com.healdoctor.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import heal.com.healdoctor.R;
import heal.com.healdoctor.helper.GlobalVariables;
import heal.com.healdoctor.otp.view.MobileNumberActivity;

/**
 * This class is used to show the login chooser to the user
 */
public class LoginChooserActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_chooser);

        ButterKnife.bind(this);

        setup();
    }

    /*
     *Initialisation of All controllers and Layout
     */
    private void setup() {
        // TODO: 04/11/18 Check this later
        /*if (AppPrefs.getBooleanPref(AppConstants.KEY_EXTRAS_LOGIN, this)) {

         *//*Intent intent = new Intent(context, NavigationActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
            finish();*//*
        }*/
    }

    @OnClick({R.id.tvLoginMobile, R.id.login_tv_sign_up})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_tv_sign_up:
                GlobalVariables.otpType=1;
                Intent intent = new Intent(this, MobileNumberActivity.class);
                startActivity(intent);
                break;

            case R.id.tvLoginMobile:
                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);
                break;
        }
    }

}
