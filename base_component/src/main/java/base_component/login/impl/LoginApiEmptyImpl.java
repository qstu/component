package base_component.login.impl;


import base_component.login.api.LoginApi;
import base_component.login.base.BaseLoginFragment;

public class LoginApiEmptyImpl implements LoginApi {

    @Override
    public BaseLoginFragment getLoginFragment() {
        return null;
    }
}
