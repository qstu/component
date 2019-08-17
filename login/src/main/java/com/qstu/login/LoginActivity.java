package com.qstu.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.qstu.login.component.LoginFragment;

import base_component.login.api.LoginApi;

@Route(path = "/login/activity")
public class LoginActivity extends AppCompatActivity {

    private Button mBtnShowFragment;
    private Button mBtnHideFragment;
    private FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        initView();

        initListener();
    }

    private void initListener() {
        mBtnShowFragment.setOnClickListener(v->showFragment());
        mBtnHideFragment.setOnClickListener(v->hideFragment());
    }

    private void hideFragment() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragmentByTag = manager.findFragmentByTag(LoginApi.LOGIN_FRAGMENT);
        if(fragmentByTag != null && fragmentByTag.isAdded()){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentByTag);
            transaction.commit();
        }
    }

    private void showFragment() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragmentByTag = manager.findFragmentByTag(LoginApi.LOGIN_FRAGMENT);
        if(fragmentByTag == null){
            fragmentByTag = new LoginFragment();
        }
        FragmentTransaction transaction = manager.beginTransaction();

        int count = mContainer.getChildCount();
        if(count > 0){
            transaction.replace(R.id.fragment_container, fragmentByTag, LoginApi.LOGIN_FRAGMENT);
        }else{
            transaction.add(R.id.fragment_container, fragmentByTag, LoginApi.LOGIN_FRAGMENT);
        }

        transaction.commit();
    }

    private void initView() {
        mBtnShowFragment = findViewById(R.id.show_fragment);
        mBtnHideFragment = findViewById(R.id.hide_fragment);
        mContainer = findViewById(R.id.fragment_container);
    }
}
