package com.qstu.base;

import android.app.Application;

public abstract class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initModule(this);
        initModuleData(this);
    }

    public abstract void initModule(Application application);

    public abstract void initModuleData(Application application);
}
