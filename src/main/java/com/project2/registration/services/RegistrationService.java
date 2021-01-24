package com.project2.registration.services;

import com.project2.registration.entity.*;

public interface RegistrationService {
    UserData addUser(UserDTO userDTO);

    UserData findByChannelIdAndEmailAndPassword(int channelId,String email, String password);

    UserDTO updateData(UserDTO userDTO);

    UserData loginMaster(int channelId, String email, String password);
}
