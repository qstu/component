package com.qstu.login;

import android.app.Application;
import android.util.Log;

import com.qstu.base.BaseApp;

import base_component.login.LoginService;

public class LoginApp extends BaseApp {

    private static final String TAG = "LoginApp";

    @Override
    public void initModule(Application application) {
        Log.d(TAG, "LoginApp[initModule] start");
        //初始化login实现模块,对外提供出口,真正接通
        LoginService.getInstance().setLoginApi(new LoginApiImpl());
        Log.d(TAG, "LoginApp[initModule] end");
    }

    @Override
    public void initModuleData(Application application) {

    }
}
