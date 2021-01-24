package com.project2.registration.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompositeKey.class)
public class ModeratorsCorporate {
    @Id
    private int channelId;
    @Id
    //todo : phani : rename userId to pageId
    private String userId;
    private String moderatorId;

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(String moderatorId) {
        this.moderatorId = moderatorId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
