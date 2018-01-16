package com.apps.ivladik.vkfeed.rest.model.response;

import com.apps.ivladik.vkfeed.model.Group;
import com.apps.ivladik.vkfeed.model.Owner;
import com.apps.ivladik.vkfeed.model.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v.falzan on 16.01.2018.
 */

public class ItemWithSendersResponse<T> extends BaseItemResponse<T> {
    private List<Profile> profiles = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    private List<Profile> getProfiles() {
        return profiles;
    }

    private List<Group> getGroups() {
        return groups;
    }

    private List<Owner> getAllSenders() {
        List<Owner> all = new ArrayList<>();
        all.addAll(getProfiles());
        all.addAll(getGroups());

        return all;
    }

    public Owner getSender(int id) {
        for (Owner owner : getAllSenders()) {
            if (owner.getId() == Math.abs(id)) {
                return owner;
            }
        }

        return null;
    }
}
