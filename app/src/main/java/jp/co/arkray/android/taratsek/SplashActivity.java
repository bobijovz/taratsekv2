package jp.co.arkray.android.taratsek;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jp.co.arkray.android.taratsek.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {


    ActivitySplashBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_splash);

        LoginFragment mFragment = new LoginFragment();

        FragmentTransaction mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.add(R.id.frame_login_container, mFragment);
        mTransaction.commit();


    }
}
