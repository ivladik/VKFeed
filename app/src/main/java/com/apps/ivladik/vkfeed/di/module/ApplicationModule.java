package com.apps.ivladik.vkfeed.di.module;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 810345 on 30.12.2017.
 */
@Module
public class ApplicationModule {
    private Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return mApplication;
    }

    @Singleton
    @Provides
    Typeface provideGoogleTypeface(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "MaterialIcons-Regular.ttf");
    }
}
