package com.apps.ivladik.vkfeed.model.view.counter;

import com.apps.ivladik.vkfeed.model.Reposts;

/**
 * Created by d.ilyin on 18.01.2018.
 */

public class RepostCounterViewModel extends CounterViewModel {

    private Reposts mReposts;

    public RepostCounterViewModel(Reposts reposts) {
        super(reposts.getCount());

        mReposts = reposts;
        if (mReposts.getUserReposted() == 1) {
            setAccentColor();
        }
    }

    public Reposts getReposts() {
        return mReposts;
    }
}
