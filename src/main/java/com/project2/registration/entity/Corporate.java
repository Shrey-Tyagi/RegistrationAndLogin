package com.project2.registration.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompositeCorporate.class)
public class Corporate {
    @Id
    private int channelId;
    @Id
    private String pageId;
    private String userId;
    private int role;
    //0 user 1 moderator 2 owner

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getUserIds() {
        return userId;
    }

    public void setUserIds(String userIds) {
        this.userId = userIds;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
