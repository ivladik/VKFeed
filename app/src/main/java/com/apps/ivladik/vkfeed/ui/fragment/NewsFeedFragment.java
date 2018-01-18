package com.apps.ivladik.vkfeed.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.apps.ivladik.vkfeed.MyApplication;
import com.apps.ivladik.vkfeed.R;
import com.apps.ivladik.vkfeed.common.utils.VkListHelper;
import com.apps.ivladik.vkfeed.model.view.BaseViewModel;
import com.apps.ivladik.vkfeed.model.view.NewsItemBodyViewModel;
import com.apps.ivladik.vkfeed.model.view.NewsItemFooterViewModel;
import com.apps.ivladik.vkfeed.model.view.NewsItemHeaderViewModel;
import com.apps.ivladik.vkfeed.rest.api.WallApi;
import com.apps.ivladik.vkfeed.rest.model.request.WallGetRequestModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFeedFragment {
    @Inject
    WallApi mWallApi;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mWallApi.get(new WallGetRequestModel(-86529522).toMap()).flatMap(wallGetResponse -> Observable.fromIterable(VkListHelper.getWallList(wallGetResponse.response)))
                .flatMap(wallItem -> {
                    List<BaseViewModel> baseItems = new ArrayList<>();
                    baseItems.add(new NewsItemHeaderViewModel(wallItem));
                    baseItems.add(new NewsItemBodyViewModel(wallItem));
                    baseItems.add(new NewsItemFooterViewModel(wallItem));
                    return Observable.fromIterable(baseItems);
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseViewModels -> mBaseAdapter.addItems(baseViewModels));
    }

    /*enqueue(new Callback<WallGetResponse>() {
        @Override
        public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {
            List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
            List<BaseViewModel> list = new ArrayList<>();

            for (WallItem item : wallItems) {
                list.add(new NewsItemHeaderViewModel(item));
                list.add(new NewsItemBodyViewModel(item));
                list.add(new NewsItemFooterViewModel(item));
            }

            mBaseAdapter.addItems(list);

            Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onFailure(Call<WallGetResponse> call, Throwable t) {
            t.printStackTrace();
        }
    });*/

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }
}
