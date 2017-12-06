package jp.co.arkray.android.taratsek;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.co.arkray.android.taratsek.AppIntro.TutorialActivity;
import jp.co.arkray.android.taratsek.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private FragmentLoginBinding mBinding;

    public LoginFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        initialize();
        return mBinding.getRoot();
    }

    public void initialize(){
        mBinding.btnLogin.setOnClickListener(this);
        mBinding.btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                Intent i = new Intent(getActivity().getApplicationContext(), TutorialActivity.class);
                startActivity(i);
                break;
            case R.id.btn_register:

                break;
        }
    }
}
