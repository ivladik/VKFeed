package com.apps.ivladik.vkfeed.common.utils;

import com.apps.ivladik.vkfeed.model.Owner;
import com.apps.ivladik.vkfeed.model.WallItem;
import com.apps.ivladik.vkfeed.rest.model.response.ItemWithSendersResponse;

import java.util.List;

/**
 * Created by d.ilyin on 17.01.2018.
 */

public class VkListHelper {
    public static List<WallItem> getWallList(ItemWithSendersResponse<WallItem> response) {
        List<WallItem> wallItems = response.items;

        for (WallItem wallItem : wallItems) {
            Owner sender = response.getSender(wallItem.getFromId());
            wallItem.setSenderName(sender.getFullName());
            wallItem.setSenderPhoto(sender.getPhoto());

            if (wallItem.haveSharedRepost()) {
                Owner repostSender = response.getSender(wallItem.getSharedRepost().getFromId());
                wallItem.getSharedRepost().setSenderName(repostSender.getFullName());
                wallItem.getSharedRepost().setSenderPhoto(repostSender.getPhoto());
            }
        }

        return wallItems;
    }
}
