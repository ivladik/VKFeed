package com.apps.ivladik.vkfeed.mvp.presenter;

import com.apps.ivladik.vkfeed.MyApplication;
import com.apps.ivladik.vkfeed.common.utils.VkListHelper;
import com.apps.ivladik.vkfeed.model.WallItem;
import com.apps.ivladik.vkfeed.model.view.BaseViewModel;
import com.apps.ivladik.vkfeed.model.view.NewsItemBodyViewModel;
import com.apps.ivladik.vkfeed.model.view.NewsItemFooterViewModel;
import com.apps.ivladik.vkfeed.model.view.NewsItemHeaderViewModel;
import com.apps.ivladik.vkfeed.mvp.view.BaseFeedView;
import com.apps.ivladik.vkfeed.rest.api.WallApi;
import com.apps.ivladik.vkfeed.rest.model.request.WallGetRequestModel;
import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by d.ilyin on 19.01.2018.
 */

@InjectViewState

public class NewsFeedPresenter extends BaseFeedPresenter<BaseFeedView> {

    @Inject
    WallApi mWallApi;

    public NewsFeedPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mWallApi.get(new WallGetRequestModel(-86529522, count, offset).toMap())
                .flatMap(wallGetResponse -> Observable.fromIterable(VkListHelper.getWallList(wallGetResponse.response)))
                .doOnNext(this::saveToDb)
                .flatMap(wallItem -> {
                    List<BaseViewModel> baseItems = new ArrayList<>();
                    baseItems.add(new NewsItemHeaderViewModel(wallItem));
                    baseItems.add(new NewsItemBodyViewModel(wallItem));
                    baseItems.add(new NewsItemFooterViewModel(wallItem));

                    return Observable.fromIterable(baseItems);
                });
    }

    public Callable<List<WallItem>> getListFromRealmCallable() {
        return () -> {
            String[] sortFields = {"date"};
            Sort[] sortOrder = {Sort.DESCENDING};
            Realm realm = Realm.getDefaultInstance();
            RealmResults<WallItem> realmResults = realm.where(WallItem.class)
                    .findAllSorted(sortFields, sortOrder);

            return realm.copyFromRealm(realmResults);
        };
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .flatMap(Observable::fromIterable)
                .flatMap(wallItem -> Observable.fromIterable(parsePojoModel(wallItem)));
    }

    private List<BaseViewModel> parsePojoModel(WallItem wallItem) {
        List<BaseViewModel> baseItems = new ArrayList<>();
        baseItems.add(new NewsItemHeaderViewModel(wallItem));
        baseItems.add(new NewsItemBodyViewModel(wallItem));
        baseItems.add(new NewsItemFooterViewModel(wallItem));

        return baseItems;
    }
}