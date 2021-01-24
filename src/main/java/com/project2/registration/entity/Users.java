package com.project2.registration.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
@IdClass(CompositeKey.class)
public class Users {
    @Id
    private String userId;
    @Id
    private int channelId;
    private String name;
    private String username;
    private String email;
    private String password;
    private String dateOfBirth;
    private long mobileNumber;
    private String profileImage;
    private boolean type;
    private boolean corporateEntity;
    private String areaOfInterests;
    private String bio;
    private boolean master;
    private String notificationToken;



    public String getNotificationToken() {
        return notificationToken;
    }

    public void setNotificationToken(String notificationToken) {
        this.notificationToken = notificationToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isCorporateEntity() {
        return corporateEntity;
    }

    public void setCorporateEntity(boolean corporateEntity) {
        this.corporateEntity = corporateEntity;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getAreaOfInterests() {
        return areaOfInterests;
    }

    public void setAreaOfInterests(String areaOfInterests) {
        this.areaOfInterests = areaOfInterests;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

}
