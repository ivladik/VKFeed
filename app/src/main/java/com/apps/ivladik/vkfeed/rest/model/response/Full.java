package com.apps.ivladik.vkfeed.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by 810345 on 30.12.2017.
 */

public class Full<T> {
    @SerializedName("response")
    @Expose
    public T response;
}
