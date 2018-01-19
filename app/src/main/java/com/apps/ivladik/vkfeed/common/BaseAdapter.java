package com.apps.ivladik.vkfeed.common;

import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.apps.ivladik.vkfeed.model.view.BaseViewModel;
import com.apps.ivladik.vkfeed.ui.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 09.01.2018.
 */

public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder<BaseViewModel>> {
    private List<BaseViewModel> list = new ArrayList<>();

    private ArrayMap<Integer, BaseViewModel> mTypeInstances = new ArrayMap<>();

    @Override
    public BaseViewHolder<BaseViewModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        return mTypeInstances.get(viewType).createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<BaseViewModel> holder, int position) {
        holder.bindViewHolder(getItem(position));
    }

    @Override
    public void onViewRecycled(BaseViewHolder<BaseViewModel> holder) {
        super.onViewRecycled(holder);
        holder.unbindViewHolder();
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType().getId();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public BaseViewModel getItem(int position) {
        return list.get(position);
    }

    public void registerTypeInstance(BaseViewModel item) {
        if (!mTypeInstances.containsKey(item.getType().getId())) {
            mTypeInstances.put(item.getType().getId(), item);
        }
    }

    public void addItems(List<? extends BaseViewModel> newItems) {
        for (BaseViewModel newItem : newItems) {
            registerTypeInstance(newItem);
        }

        list.addAll(newItems);
        notifyDataSetChanged();
    }

    public void setItems(List<BaseViewModel> items) {
        clearList();
        addItems(items);
    }

    public void clearList() {
        list.clear();
    }

    public int getRealItemCount() {
        int count = 0;

        for (int i = 0; i < getItemCount(); i++)
            if (!getItem(i).isItemDecorator()) count++;

        return count;
    }
}
