package heal.com.healdoctor.dashboard.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import heal.com.healdoctor.R;

public class NavigationActivity extends AppCompatActivity
        implements OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.tvAddMain)
    TextView tvAddMain;
    @BindView(R.id.tvNameMain)
    TextView tvNameMain;
    @BindView(R.id.lnr_profile)
    LinearLayout lnrProfile;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.tvConfrm)
    TextView tvConfrm;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.tvCancel)
    TextView tvCancel;
    @BindView(R.id.textView15)
    TextView textView15;
    @BindView(R.id.tvShowAll)
    TextView tvShowAll;
    @BindView(R.id.imageView42)
    ImageView imageView42;
    @BindView(R.id.textView51)
    TextView textView51;
    @BindView(R.id.lnr_all_appointment)
    LinearLayout lnrAllAppointment;
    @BindView(R.id.lnr_all_patients)
    LinearLayout lnrAllPatients;
    @BindView(R.id.lnr_practice)
    LinearLayout lnrPractice;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.textView512)
    TextView textView512;
    @BindView(R.id.lnr_chat)
    LinearLayout lnrChat;
    @BindView(R.id.btnBook)
    TextView btnBook;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private Context mContext = NavigationActivity.this;

    private static final int REQUEST_CODE_PERMISSION_LOCATIONSETTING = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @OnClick(R.id.btnBook)
    public void onViewClicked() {
    }
}
