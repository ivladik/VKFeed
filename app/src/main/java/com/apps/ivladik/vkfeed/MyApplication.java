package com.apps.ivladik.vkfeed;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by admin on 28.12.2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
