package base_component.login;

import base_component.login.api.LoginApi;
import base_component.login.impl.LoginApiEmptyImpl;

public class LoginService {

    private volatile LoginApi mLoginApi;

    private LoginService(){}

    public static LoginService getInstance(){
        return HOLDER.loginService;
    }

    public void setLoginApi(LoginApi loginApi){
        synchronized (LoginApi.class){
            mLoginApi = loginApi;
        }
    }

    public LoginApi getLoginApi(){
        if(mLoginApi == null){
            synchronized (LoginApi.class){
                if(mLoginApi == null){
                    mLoginApi = new LoginApiEmptyImpl();
                }
            }
        }
        return mLoginApi;
    }


    private static class HOLDER{
        private static LoginService loginService = new LoginService();
    }
}
