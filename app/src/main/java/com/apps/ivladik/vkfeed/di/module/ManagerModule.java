package com.apps.ivladik.vkfeed.di.module;

import com.apps.ivladik.vkfeed.common.manager.MyFragmentManager;
import com.apps.ivladik.vkfeed.common.manager.NetworkManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 810345 on 30.12.2017.
 */
@Module
public class ManagerModule {
    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager() {
        return new MyFragmentManager();
    }

    @Provides
    @Singleton
    NetworkManager providesNetworkManager() {
        return new NetworkManager();
    }
}
