package com.apps.ivladik.vkfeed.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.apps.ivladik.vkfeed.R;
import com.apps.ivladik.vkfeed.common.BaseAdapter;

/**
 * Created by d.ilyin on 18.01.2018.
 */

public class BaseFeedFragment extends BaseFragment {

    RecyclerView mRecyclerView;
    BaseAdapter mBaseAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }

    private void setUpRecyclerView(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setUpAdapter(RecyclerView recyclerView) {
        mBaseAdapter = new BaseAdapter();

        recyclerView.setAdapter(mBaseAdapter);
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return 0;
    }
}
