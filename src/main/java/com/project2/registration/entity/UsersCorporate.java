package com.project2.registration.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompositeKey.class)
public class UsersCorporate {
    @Id
    private int channelId;
    @Id
    //todo : phani : rename userId to pageId
    private String userId;
    //todo : what is usersId ?? I am loosing tracking of my mind!!
    private String usersId;

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }
}
