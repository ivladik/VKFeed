package com.apps.ivladik.vkfeed.model.view;

import android.view.View;

import com.apps.ivladik.vkfeed.model.WallItem;
import com.apps.ivladik.vkfeed.ui.holder.BaseViewHolder;
import com.apps.ivladik.vkfeed.ui.holder.NewsItemBodyHolder;

/**
 * Created by admin on 09.01.2018.
 */

public class NewsItemBodyViewModel extends BaseViewModel {

    private int mId;
    private String mText;
    private String mAttachmentString;
    private boolean mIsRepost;

    public NewsItemBodyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mIsRepost = wallItem.haveSharedRepost();

        if (mIsRepost) {
            this.mText = wallItem.getSharedRepost().getText();
            this.mAttachmentString = wallItem.getSharedRepost().getAttachmentString();
        } else {
            this.mText = wallItem.getText();
            this.mAttachmentString = wallItem.getAttachmentString();
        }
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }

    public int getId() {
        return mId;
    }

    public String getText() {
        return mText;
    }

    public String getAttachmentString() {
        return mAttachmentString;
    }
}
