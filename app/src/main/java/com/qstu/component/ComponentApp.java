package com.qstu.component;

import android.app.Application;
import android.util.Log;

import com.qstu.base.BaseApp;
import com.qstu.base.BaseConfig;

public class ComponentApp extends BaseApp {

    private static final String TAG = "ComponentApp";


    @Override
    protected boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public void initModule(Application application) {
        for (int i = 0; i < BaseConfig.COMPONENT_PATH.length; i++){
            String componentPath = BaseConfig.COMPONENT_PATH[i];
            try {
                Log.d(TAG, componentPath + " module init start");
                Class forName = Class.forName(componentPath);
                BaseApp baseApp = (BaseApp) (forName.newInstance());
                baseApp.initModule(this);

                Log.d(TAG, componentPath + " module init end");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void initModuleData(Application application) {
        for (int i = 0; i < BaseConfig.COMPONENT_PATH.length; i++){
            String componentPath = BaseConfig.COMPONENT_PATH[i];
            try {
                Log.d(TAG, componentPath + " data init start");
                Class forName = Class.forName(componentPath);
                BaseApp baseApp = (BaseApp) (forName.newInstance());
                baseApp.initModuleData(this);

                Log.d(TAG, componentPath + " data init end");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        }
    }
}
