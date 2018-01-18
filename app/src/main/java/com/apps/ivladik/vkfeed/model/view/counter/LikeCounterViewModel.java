package com.apps.ivladik.vkfeed.model.view.counter;

import com.apps.ivladik.vkfeed.model.Likes;

/**
 * Created by d.ilyin on 18.01.2018.
 */

public class LikeCounterViewModel extends CounterViewModel {

    private Likes mLikes;

    public LikeCounterViewModel(Likes likes) {
        super(likes.getCount());

        this.mLikes = likes;
        if (mLikes.getUserLikes() == 1) {
            setAccentColor();
        }
    }

    public Likes getLikes() {
        return mLikes;
    }
}
