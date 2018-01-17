package com.apps.ivladik.vkfeed.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.apps.ivladik.vkfeed.R;
import com.apps.ivladik.vkfeed.model.view.NewsItemBodyViewModel;

/**
 * Created by admin on 09.01.2018.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {
    public TextView mTextView;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);

        mTextView = (TextView) itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel newsItemBodyViewModel) {
        mTextView.setText(newsItemBodyViewModel.getText());
    }

    @Override
    public void unbindViewHolder() {
        mTextView.setText(null);
    }
}
