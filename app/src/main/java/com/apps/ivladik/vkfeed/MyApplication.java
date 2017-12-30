package com.apps.ivladik.vkfeed;

import android.app.Application;

import com.apps.ivladik.vkfeed.di.component.ApplicationComponent;
import com.apps.ivladik.vkfeed.di.component.DaggerApplicationComponent;
import com.apps.ivladik.vkfeed.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;

/**
 * Created by admin on 28.12.2017.
 */

public class MyApplication extends Application {
    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);
    }

    private void initComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
