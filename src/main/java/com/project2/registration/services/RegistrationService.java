package com.project2.registration.services;

import com.project2.registration.entity.*;

public interface RegistrationService {
    UserData addUser(Users users);

    UserData findByChannelIdAndEmailAndPassword(int channelId,String email, String password);

    Users updateData(String imgUrl);

    OwnersCorporate addOwnerData(OwnersCorporate ownersCorporate);

    UsersCorporate addUsersData(UsersCorporate usersCorporate);

    ModeratorsCorporate addModeratorsData(ModeratorsCorporate moderatorsCorporate);

    OwnersCorporate findByChannelIdAndUserIdOwner(int channelId, String userId);

    ModeratorsCorporate findByChannelIdAndUserIdModerator(int channelId, String userId);

    UsersCorporate findByChannelIdAndUserIdUsers(int channelId, String userId);

    UsersCorporate updateUserData(UsersCorporate usersCorporate);

    ModeratorsCorporate updateModeratorsData(ModeratorsCorporate moderatorsCorporate);

    OwnersCorporate updateOwnerData(OwnersCorporate ownersCorporate);
}
