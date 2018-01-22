package com.apps.ivladik.vkfeed.common.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.apps.ivladik.vkfeed.MyApplication;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.internal.Util;

/**
 * Created by User on 22.01.2018.
 */

public class NetworkManager {

    @Inject
    Context mContext;
    private static final String TAG = "NetworkManager";

    public NetworkManager() {
        MyApplication.getApplicationComponent().inject(this);
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        return ((ni != null && ni.isConnected()) || Util.isEmulator());
    }

    public Callable<Boolean> isVkReachableCallable() {
        return () -> {
            try {
                if (!isOnline()) {
                    return false;
                }

                URL url = new URL("https://api.vk.com");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(2000);
                connection.connect();

                return true;
            } catch (Exception e) {
                return false;
            }
        };
    }

    public Observable<Boolean> getNetworkObservable() {
        return Observable.fromCallable(isVkReachableCallable());
    }
}
