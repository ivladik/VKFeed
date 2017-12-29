package com.apps.ivladik.vkfeed.mvp.presenter;

import com.apps.ivladik.vkfeed.CurrentUser;
import com.apps.ivladik.vkfeed.mvp.view.MainView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

/**
 * Created by admin on 28.12.2017.
 */
@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    public void checkAuth() {
        if (!CurrentUser.isAuthorized()) {
            getViewState().startSignIn();
        } else {
            getViewState().signedId();
        }
    }
}
