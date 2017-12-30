package com.apps.ivladik.vkfeed.di.module;

import com.apps.ivladik.vkfeed.rest.RestClient;

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
}
