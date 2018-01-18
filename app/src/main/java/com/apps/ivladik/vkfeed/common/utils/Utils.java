package com.apps.ivladik.vkfeed.common.utils;

import com.apps.ivladik.vkfeed.model.attachment.ApiAttachment;
import com.vk.sdk.api.model.VKAttachments;

import java.util.List;

/**
 * Created by d.ilyin on 18.01.2018.
 */

public class Utils {
    public static String convertAttachmentsToFontIcons(List<ApiAttachment> attachments) {
        String attachmentString = "";

        for (ApiAttachment attachment : attachments) {
            switch (attachment.getType()) {
                case VKAttachments.TYPE_PHOTO:
                    attachmentString += new String(new char[]{0xE251}) + " ";
                    break;
                case VKAttachments.TYPE_AUDIO:
                    attachmentString += new String(new char[]{0xE310}) + " ";
                    break;
                case VKAttachments.TYPE_VIDEO:
                    attachmentString += new String(new char[]{0xE02C}) + " ";
                    break;
                case VKAttachments.TYPE_LINK:
                    attachmentString += new String(new char[]{0xE250}) + " ";
                    break;
                case VKAttachments.TYPE_DOC:
                    attachmentString += new String(new char[]{0xE24D}) + " ";
                    break;
            }
        }

        return attachmentString;
    }
}
