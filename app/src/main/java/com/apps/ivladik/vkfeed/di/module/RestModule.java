package com.apps.ivladik.vkfeed.di.module;

import com.apps.ivladik.vkfeed.rest.RestClient;
import com.apps.ivladik.vkfeed.rest.api.WallApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 810345 on 30.12.2017.
 */
@Module
public class RestModule {
    private RestClient mRestClient;

    public RestModule() {
        mRestClient = new RestClient();
    }

    @Singleton
    @Provides
    public RestClient provideRestClient() {
        return mRestClient;
    }

    @Singleton
    @Provides
    public WallApi provideWallApi() {
        return mRestClient.createService(WallApi.class);
    }
}
