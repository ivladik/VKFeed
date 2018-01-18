package com.apps.ivladik.vkfeed.ui.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.apps.ivladik.vkfeed.MyApplication;
import com.apps.ivladik.vkfeed.R;
import com.apps.ivladik.vkfeed.common.utils.Utils;
import com.apps.ivladik.vkfeed.model.view.NewsItemFooterViewModel;
import com.apps.ivladik.vkfeed.model.view.counter.CommentCounterViewModel;
import com.apps.ivladik.vkfeed.model.view.counter.LikeCounterViewModel;
import com.apps.ivladik.vkfeed.model.view.counter.RepostCounterViewModel;

import javax.inject.Inject;

/**
 * Created by d.ilyin on 18.01.2018.
 */

public class NewsItemFooterHolder extends BaseViewHolder<NewsItemFooterViewModel> {

    private TextView tvDate;

    private TextView tvLikesCount;
    private TextView tvLikesIcon;
    private TextView tvCommentsCount;
    private TextView tvCommentsIcon;
    private TextView tvRepostsCount;
    private TextView tvRepostsIcon;

    @Inject
    Typeface mGoogleFontTypeface;

    private Resources mResources;
    private Context mContext;

    public NewsItemFooterHolder(View itemView) {
        super(itemView);
        MyApplication.getApplicationComponent().inject(this);

        mContext = itemView.getContext();
        mResources = mContext.getResources();

        tvDate = (TextView) itemView.findViewById(R.id.tv_date);

        tvLikesCount = (TextView) itemView.findViewById(R.id.tv_likes_count);
        tvLikesIcon = (TextView) itemView.findViewById(R.id.tv_likes_icon);
        tvCommentsCount = (TextView) itemView.findViewById(R.id.tv_comments_count);
        tvCommentsIcon = (TextView) itemView.findViewById(R.id.tv_comments_icon);
        tvRepostsCount = (TextView) itemView.findViewById(R.id.tv_reposts_count);
        tvRepostsIcon = (TextView) itemView.findViewById(R.id.tv_reposts_icon);

        tvLikesIcon.setTypeface(mGoogleFontTypeface);
        tvCommentsIcon.setTypeface(mGoogleFontTypeface);
        tvRepostsIcon.setTypeface(mGoogleFontTypeface);
    }

    @Override
    public void bindViewHolder(NewsItemFooterViewModel item) {
        tvDate.setText(Utils.parseDate(item.getDateLong(), mContext));

        bindLikes(item.getLikes());
        bindComments(item.getComments());
        bindReposts(item.getReposts());
    }

    private void bindLikes(LikeCounterViewModel likes) {
        tvLikesCount.setText(String.valueOf(likes.getCount()));
        tvLikesCount.setTextColor(mResources.getColor(likes.getTextColor()));
        tvLikesIcon.setTextColor(mResources.getColor(likes.getIconColor()));
    }

    private void bindComments(CommentCounterViewModel comments) {
        tvCommentsCount.setText(String.valueOf(comments.getCount()));
        tvCommentsCount.setTextColor(mResources.getColor(comments.getTextColor()));
        tvCommentsIcon.setTextColor(mResources.getColor(comments.getIconColor()));
    }

    private void bindReposts(RepostCounterViewModel reposts) {
        tvRepostsCount.setText(String.valueOf(reposts.getCount()));
        tvRepostsCount.setTextColor(mResources.getColor(reposts.getTextColor()));
        tvRepostsIcon.setTextColor(mResources.getColor(reposts.getIconColor()));
    }

    @Override
    public void unbindViewHolder() {
        tvDate.setText(null);

        tvLikesCount.setText(null);
        tvCommentsCount.setText(null);
        tvRepostsCount.setText(null);
    }
}
