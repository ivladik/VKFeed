package com.apps.ivladik.vkfeed.rest.api;

import com.apps.ivladik.vkfeed.rest.model.response.WallGetResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 810345 on 30.12.2017.
 */

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Observable<WallGetResponse> get(@QueryMap Map<String, String> map);
}
