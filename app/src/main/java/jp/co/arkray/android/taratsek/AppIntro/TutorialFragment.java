package jp.co.arkray.android.taratsek.AppIntro;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jp.co.arkray.android.taratsek.R;

/**
 * Created by R. R. Reyes on 12/5/2017.
 */

public class TutorialFragment extends Fragment {

    public static final String ARG_LAYOUT_STRING_ID = "TutsFrag";
    public String centerText;

    public static TutorialFragment newInstance(String centerText) {
        TutorialFragment slide = new TutorialFragment();

        Bundle args = new Bundle();
        args.putString(ARG_LAYOUT_STRING_ID, centerText);
        slide.setArguments(args);

        return slide;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_STRING_ID)) {
            centerText = getArguments().getString(ARG_LAYOUT_STRING_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.intro_layout_prototype, container, false);
        TextView tvCenterText = v.findViewById(R.id.textview_centraltext);
        tvCenterText.setText(centerText);
        return v;
    }
}
