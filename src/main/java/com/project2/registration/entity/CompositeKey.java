package com.project2.registration.entity;

import java.io.Serializable;

public class CompositeKey implements Serializable {
    private String userId;
    private int channelId;

    public CompositeKey(String userId, int channelId) {
        this.userId = userId;
        this.channelId = channelId;
    }

    public CompositeKey() {
    }
}
