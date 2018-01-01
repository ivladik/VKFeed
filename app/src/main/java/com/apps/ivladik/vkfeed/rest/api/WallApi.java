package com.apps.ivladik.vkfeed.rest.api;

import com.apps.ivladik.vkfeed.rest.model.response.BaseItemResponse;
import com.apps.ivladik.vkfeed.rest.model.response.Full;
import com.apps.ivladik.vkfeed.rest.model.response.WallGetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 810345 on 30.12.2017.
 */

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Call<WallGetResponse> get(@Query("owner_id") String ownerId,
                              @Query("access_token") String accessToken,
                              @Query("extended") Integer extended,
                              @Query("v") String version);
}
