package com.qstu.component;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

import base_component.login.LoginService;
import base_component.login.api.LoginApi;

public class MainActivity extends AppCompatActivity {

    private Button mBtnShowFragment;
    private Button mBtnHideFragment;
    private Button mBtnJumpLoginActivity;

    private FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initListener() {
        mBtnShowFragment.setOnClickListener(v->showLoginFragment());
        mBtnHideFragment.setOnClickListener(v->hideFragment());
        mBtnJumpLoginActivity.setOnClickListener(v->jumpLoginActivity());
    }

    private void jumpLoginActivity() {
        ARouter.getInstance().build("/login/activity").navigation();
    }

    private void showLoginFragment() {

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragmentByTag = manager.findFragmentByTag(LoginApi.LOGIN_FRAGMENT);
        if(fragmentByTag == null){

            fragmentByTag = LoginService.getInstance().getLoginApi().getLoginFragment();
            if(fragmentByTag == null){
                Toast.makeText(this, "Empty Login Module", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        FragmentTransaction transaction = manager.beginTransaction();

        int count = mContainer.getChildCount();
        if(count > 0){
            transaction.replace(R.id.component_container, fragmentByTag, LoginApi.LOGIN_FRAGMENT);
        }else{
            transaction.add(R.id.component_container, fragmentByTag, LoginApi.LOGIN_FRAGMENT);
        }

        transaction.commit();
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


    private void initView() {
        mBtnShowFragment = findViewById(R.id.show_login);
        mBtnHideFragment = findViewById(R.id.hide_login);
        mBtnJumpLoginActivity = findViewById(R.id.jump_login_activity);
        mContainer = findViewById(R.id.component_container);
    }
}
