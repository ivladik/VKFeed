package com.apps.ivladik.vkfeed.model.view.counter;

import com.apps.ivladik.vkfeed.model.Comments;

/**
 * Created by d.ilyin on 18.01.2018.
 */

public class CommentCounterViewModel extends CounterViewModel {

    private Comments mComments;

    public CommentCounterViewModel(Comments comments) {
        super(comments.getCount());

        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}
