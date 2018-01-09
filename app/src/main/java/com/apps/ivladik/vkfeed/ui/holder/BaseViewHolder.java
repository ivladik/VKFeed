package com.apps.ivladik.vkfeed.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.apps.ivladik.vkfeed.model.view.BaseViewModel;

/**
 * Created by admin on 09.01.2018.
 */

public abstract class BaseViewHolder<Item extends BaseViewModel> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    abstract public void bindViewHolder(Item item);

    abstract public void unbindViewHolder();
}
