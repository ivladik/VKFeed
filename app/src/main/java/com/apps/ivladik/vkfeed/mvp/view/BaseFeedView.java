package com.apps.ivladik.vkfeed.mvp.view;

import com.apps.ivladik.vkfeed.model.view.BaseViewModel;
import com.arellomobile.mvp.MvpView;

import java.util.List;

/**
 * Created by d.ilyin on 19.01.2018.
 */

public interface BaseFeedView extends MvpView {

    void showRefreshing();

    void hideRefreshing();

    void showListProgress();

    void hideListProgress();

    void showError(String message);

    void setItems(List<BaseViewModel> items);

    void addItems(List<BaseViewModel> items);
}
