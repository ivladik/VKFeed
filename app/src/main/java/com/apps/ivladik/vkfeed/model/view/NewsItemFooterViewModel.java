package com.apps.ivladik.vkfeed.model.view;

import android.view.View;

import com.apps.ivladik.vkfeed.model.WallItem;
import com.apps.ivladik.vkfeed.model.view.counter.CommentCounterViewModel;
import com.apps.ivladik.vkfeed.model.view.counter.LikeCounterViewModel;
import com.apps.ivladik.vkfeed.model.view.counter.RepostCounterViewModel;
import com.apps.ivladik.vkfeed.ui.holder.BaseViewHolder;
import com.apps.ivladik.vkfeed.ui.holder.NewsItemFooterHolder;

/**
 * Created by d.ilyin on 18.01.2018.
 */

public class NewsItemFooterViewModel extends BaseViewModel {

    private int mId;
    private int mOwnerId;
    private long mDateLong;

    private LikeCounterViewModel mLikes;
    private CommentCounterViewModel mComments;
    private RepostCounterViewModel mReposts;

    public NewsItemFooterViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mOwnerId = wallItem.getOwnerId();
        this.mDateLong = wallItem.getDate();
        this.mLikes = new LikeCounterViewModel(wallItem.getLikes());
        this.mComments = new CommentCounterViewModel(wallItem.getComments());
        this.mReposts = new RepostCounterViewModel(wallItem.getReposts());
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemFooter;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemFooterHolder(view);
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(int mOwnerId) {
        this.mOwnerId = mOwnerId;
    }

    public LikeCounterViewModel getLikes() {
        return mLikes;
    }

    public void setLikes(LikeCounterViewModel mLikes) {
        this.mLikes = mLikes;
    }

    public CommentCounterViewModel getComments() {
        return mComments;
    }

    public void setComments(CommentCounterViewModel mComments) {
        this.mComments = mComments;
    }

    public RepostCounterViewModel getReposts() {
        return mReposts;
    }

    public void setReposts(RepostCounterViewModel mReposts) {
        this.mReposts = mReposts;
    }

    public long getDateLong() {
        return mDateLong;
    }

    public void setDateLong(long mDateLong) {
        this.mDateLong = mDateLong;
    }

    @Override
    public boolean isItemDecorator() {
        return true;
    }
}
