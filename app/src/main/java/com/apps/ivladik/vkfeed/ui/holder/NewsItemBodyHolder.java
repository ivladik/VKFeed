package com.apps.ivladik.vkfeed.ui.holder;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.apps.ivladik.vkfeed.MyApplication;
import com.apps.ivladik.vkfeed.R;
import com.apps.ivladik.vkfeed.model.view.NewsItemBodyViewModel;

import javax.inject.Inject;

/**
 * Created by admin on 09.01.2018.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {
    private TextView tvText;
    private TextView tvAttachments;
    @Inject
    protected Typeface mFontGoogle;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        MyApplication.getApplicationComponent().inject(this);

        tvText = (TextView) itemView.findViewById(R.id.tv_text);
        tvAttachments = (TextView) itemView.findViewById(R.id.tv_attachments);

        if (tvAttachments != null) {
            tvAttachments.setTypeface(mFontGoogle);
        }
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel item) {
        tvText.setText(item.getText());
        tvAttachments.setText(item.getAttachmentString());
    }

    @Override
    public void unbindViewHolder() {
        tvText.setText(null);
        tvAttachments.setText(null);
    }
}
