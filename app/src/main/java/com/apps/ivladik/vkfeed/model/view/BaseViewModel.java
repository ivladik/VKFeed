package com.apps.ivladik.vkfeed.model.view;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.ivladik.vkfeed.R;
import com.apps.ivladik.vkfeed.ui.holder.BaseViewHolder;

/**
 * Created by admin on 09.01.2018.
 */

public abstract class BaseViewModel {
    public abstract  LayoutTypes getType();

    public BaseViewHolder createViewHolder(ViewGroup parent) {
        return onCreateViewHolder(LayoutInflater.from(parent.getContext()).inflate(getType().getId(), parent, false));
    }

    protected abstract BaseViewHolder onCreateViewHolder(View view);

    public enum LayoutTypes {
        NewsFeedItemHeader(R.layout.item_news_header),
        NewsFeedItemBody(R.layout.item_news_body),
        NewsFeedItemFooter(R.layout.item_news_footer);

        private final int id;

        LayoutTypes(int id) {
            this.id = id;
        }

        @LayoutRes
        public int getId() {
            return id;
        }
    }

    public boolean isItemDecorator() {
        return false;
    }
}