package jp.co.arkray.android.taratsek.AppIntro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;

import jp.co.arkray.android.taratsek.MainActivity;
import jp.co.arkray.android.taratsek.R;

/**
 * Created by R. R. Reyes on 12/5/2017.
 */

public class TutorialActivity extends AppIntro {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(TutorialFragment.newInstance("Application introduction will be displayed here."));
        addSlide(TutorialFragment.newInstance("Some tutorial and feature functions of the application and snapshots included."));
        addSlide(TutorialFragment.newInstance("Second page of tutorial and features."));
        addSlide(TutorialFragment.newInstance("Additional information about the application and data permissions to be ask on user."));

        setBarColor(Color.WHITE);
        setSeparatorColor(Color.WHITE);
        setColorDoneText(Color.WHITE);
        setColorSkipButton(Color.BLACK);
        setIndicatorColor(getResources().getColor(R.color.colorAccent),getResources().getColor(R.color.colorPrimary));
        setNextArrowColor(Color.BLACK);

        showSkipButton(true);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }
}
