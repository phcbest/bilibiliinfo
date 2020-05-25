package com.phc.bilibiliinfo.startInit;

import android.app.Application;
import android.content.Context;

/**
 * 版权：没有版权 看得上就用
 *
 * @author peng
 * 创建日期：2020/5/24 09
 * 描述：
 */
public class myApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
