package com.apps.ivladik.vkfeed.model.view;

import android.view.View;

import com.apps.ivladik.vkfeed.model.WallItem;
import com.apps.ivladik.vkfeed.ui.holder.BaseViewHolder;
import com.apps.ivladik.vkfeed.ui.holder.NewsItemHeaderHolder;

/**
 * Created by v.falzan on 16.01.2018.
 */

public class NewsItemHeaderViewModel extends BaseViewModel {

    private int mId;

    private String mProfilePhoto;
    private String mProfileName;

    private boolean mIsRepost;
    private String mRepostProfileName;

    public NewsItemHeaderViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mProfilePhoto = wallItem.getSenderPhoto();
        this.mProfileName = wallItem.getSenderName();
        this.mIsRepost = wallItem.haveSharedRepost();
        if (mIsRepost)
            this.mRepostProfileName = wallItem.getSharedRepost().senderName;
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemHeader;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemHeaderHolder(view);
    }

    public int getId() {
        return mId;
    }

    public String getProfilePhoto() {
        return mProfilePhoto;
    }

    public String getProfileName() {
        return mProfileName;
    }

    public boolean isRepost() {
        return mIsRepost;
    }

    public String getRepostProfileName() {
        return mRepostProfileName;
    }
}
