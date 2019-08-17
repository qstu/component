package com.qstu.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public abstract class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initModule(this);
        initModuleData(this);

        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    protected boolean isDebug(){
        return BuildConfig.DEBUG;
    }

    public abstract void initModule(Application application);

    public abstract void initModuleData(Application application);
}
