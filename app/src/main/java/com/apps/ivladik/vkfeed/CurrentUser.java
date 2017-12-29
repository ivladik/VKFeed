package com.apps.ivladik.vkfeed;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;

/**
 * Created by admin on 28.12.2017.
 */

public class CurrentUser {
    public static String getAccessToken() {
        return VKAccessToken.currentToken() == null ? null : VKAccessToken.currentToken().accessToken;
    }

    public static String getId() {
        return VKAccessToken.currentToken() == null ? null : VKAccessToken.currentToken().userId;
    }

    public static boolean isAuthorized() {
        return VKSdk.isLoggedIn()
                && VKAccessToken.currentToken() != null
                && !VKAccessToken.currentToken().isExpired();
    }
}
