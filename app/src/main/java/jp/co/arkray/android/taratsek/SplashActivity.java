package jp.co.arkray.android.taratsek;

import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.transition.TransitionManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import jp.co.arkray.android.taratsek.Utilities.AnimUtils;
import jp.co.arkray.android.taratsek.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity{

    private ActivitySplashBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_splash);
        initialize();

    }

    public void initialize(){

        LoginFragment mFragment = new LoginFragment();
        FragmentTransaction mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.add(R.id.frame_login_container, mFragment);
        mTransaction.commit();

        mBinding.progressSplashLoading.setVisibility(View.VISIBLE);
        AnimUtils.collapse(mBinding.frameLoginContainer);
        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                mBinding.progressSplashLoading.setVisibility(View.GONE);
                AnimUtils.expand(mBinding.frameLoginContainer);
            }
        };
        handler.postDelayed(r, 5000);
    }

}
