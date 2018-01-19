package com.apps.ivladik.vkfeed.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.apps.ivladik.vkfeed.MyApplication;
import com.apps.ivladik.vkfeed.R;
import com.apps.ivladik.vkfeed.common.manager.MyFragmentManager;
import com.apps.ivladik.vkfeed.ui.fragment.BaseFragment;
import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

/**
 * Created by admin on 28.12.2017.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

    protected ProgressBar mProgressBar;
    @Inject
    MyFragmentManager myFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
        setContentView(R.layout.activity_base);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout parent = (FrameLayout) findViewById(R.id.main_wrapper);
        getLayoutInflater().inflate(getMainContentLayout(), parent);
    }

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    @LayoutRes
    protected abstract int getMainContentLayout();

    public void fragmentOnScreen(BaseFragment fragment) {
        setToolbarTitle(fragment.createToolbarTitle(this));
    }

    public void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void setContent(BaseFragment fragment) {
        myFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
    }

    public void addContent(BaseFragment fragment) {
        myFragmentManager.addFragment(this, fragment, R.id.main_wrapper);
    }

    public boolean removeCurrentFragment() {
        return myFragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment(BaseFragment fragment) {
        return myFragmentManager.removeFragment(this, fragment);
    }

    @Override
    public void onBackPressed() {
        removeCurrentFragment();
    }
}