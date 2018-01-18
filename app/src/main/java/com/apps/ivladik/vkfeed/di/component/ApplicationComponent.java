package com.apps.ivladik.vkfeed.di.component;

import com.apps.ivladik.vkfeed.di.module.ApplicationModule;
import com.apps.ivladik.vkfeed.di.module.ManagerModule;
import com.apps.ivladik.vkfeed.di.module.RestModule;
import com.apps.ivladik.vkfeed.ui.activity.BaseActivity;
import com.apps.ivladik.vkfeed.ui.activity.MainActivity;
import com.apps.ivladik.vkfeed.ui.fragment.NewsFeedFragment;
import com.apps.ivladik.vkfeed.ui.holder.NewsItemBodyHolder;
import com.apps.ivladik.vkfeed.ui.holder.NewsItemFooterHolder;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 810345 on 30.12.2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity activity);

    void inject(MainActivity activity);

    void inject(NewsFeedFragment fragment);

    void inject(NewsItemBodyHolder holder);

    void inject(NewsItemFooterHolder holder);
}
