package com.apps.ivladik.vkfeed.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.apps.ivladik.vkfeed.R;
import com.apps.ivladik.vkfeed.model.view.NewsFeedItemBodyViewModel;

/**
 * Created by admin on 09.01.2018.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsFeedItemBodyViewModel> {
    public TextView mTextView;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);

        mTextView = (TextView) itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsFeedItemBodyViewModel newsFeedItemBodyViewModel) {
        mTextView.setText(newsFeedItemBodyViewModel.getText());
    }

    @Override
    public void unbindViewHolder() {
        mTextView.setText(null);
    }
}
