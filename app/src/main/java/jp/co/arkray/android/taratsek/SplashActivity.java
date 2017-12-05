package jp.co.arkray.android.taratsek;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import jp.co.arkray.android.taratsek.Utilities.AnimUtils;
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
        //AnimUtils.collapse(mBinding.frameLoginContainer);
        mBinding.frameLoginContainer.setVisibility(View.INVISIBLE);
        mBinding.progressSplashLoading.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                mBinding.progressSplashLoading.setVisibility(View.GONE);

                //AnimUtils.expand(mBinding.frameLoginContainer);
                //handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(r, 5000);






    }
}
