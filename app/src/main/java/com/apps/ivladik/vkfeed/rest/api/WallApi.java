package com.apps.ivladik.vkfeed.rest.api;

import com.apps.ivladik.vkfeed.rest.model.response.BaseItemResponse;
import com.apps.ivladik.vkfeed.rest.model.response.Full;
import com.apps.ivladik.vkfeed.rest.model.response.WallGetResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by 810345 on 30.12.2017.
 */

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Call<WallGetResponse> get(@QueryMap Map<String, String> map);
}
