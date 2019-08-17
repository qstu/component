package com.qstu.login;

import com.qstu.login.component.LoginFragment;

import base_component.login.api.LoginApi;
import base_component.login.base.BaseLoginFragment;

public class LoginApiImpl implements LoginApi {

    @Override
    public BaseLoginFragment getLoginFragment() {
        return new LoginFragment();
    }
}
