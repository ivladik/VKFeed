package com.apps.ivladik.vkfeed.model;

import com.vk.sdk.api.model.Identifiable;

/**
 * Created by v.falzan on 16.01.2018.
 */

public interface Owner extends Identifiable {
    String getFullName();

    String getPhoto();
}
