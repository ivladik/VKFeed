package com.apps.ivladik.vkfeed.rest.model.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 810345 on 30.12.2017.
 */

public class BaseItemResponse<T> {
    public Integer count;
    public List<T> items = new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    public List<T> getItems() {
        return items;
    }
}
