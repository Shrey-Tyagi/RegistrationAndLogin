package com.project2.registration.models;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {
    private String email;
    private String password;
    private int channelId;
    private int oauth;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getOauth() {
        return oauth;
    }

    public void setOauth(int oauth) {
        this.oauth = oauth;
    }

    //need default constructor for JSON Parsing
    public AuthenticationRequest()
    {

    }

    public AuthenticationRequest(String username, String password, int channelId, int oauth) {
        this.setEmail(username);
        this.setPassword(password);
        this.setChannelId(channelId);
        this.setOauth(oauth);
    }
}
