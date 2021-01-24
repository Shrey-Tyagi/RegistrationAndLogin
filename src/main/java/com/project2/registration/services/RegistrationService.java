package com.project2.registration.services;

import com.project2.registration.entity.*;

public interface RegistrationService {
    UserData addUser(Users users);

    UserData findByChannelIdAndEmailAndPassword(int channelId,String email, String password);

    Users updateData(String imgUrl);
}
