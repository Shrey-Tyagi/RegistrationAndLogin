package com.project2.registration.services.impl;

import com.project2.registration.entity.LoginHistory;
import com.project2.registration.entity.RegistrationHistory;
import com.project2.registration.entity.Users;
import com.project2.registration.repository.LoginHistoryRepository;
import com.project2.registration.repository.RegistrationRepository;
import com.project2.registration.services.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {

    @Autowired
    LoginHistoryRepository loginHistoryRepository;
    @Autowired
    RegistrationRepository registrationRepository;

    @Override
    public LoginHistory save(LoginHistory loginHistory) {
        return loginHistoryRepository.save(loginHistory);
    }

    @Override
    public List<LoginHistory> findAll() {
        Iterable<LoginHistory> loginHistoryIterable = loginHistoryRepository.findAll();
        List<LoginHistory> loginHistoryList = new ArrayList<>();
        loginHistoryIterable.forEach(loginHistoryList:: add);
        return loginHistoryList;
    }

    @Override
    public List<RegistrationHistory> findAllRegistrationData() {
        Iterable<Users> usersIterable = registrationRepository.findAll();
        List<Users> usersList = new ArrayList<>();
        usersIterable.forEach(usersList:: add);
        List<RegistrationHistory> registrationHistoryList = new ArrayList<>();
        for(int i=0;i< usersList.size();i++){
            Users users = usersList.get(i);
            RegistrationHistory registrationHistory = new RegistrationHistory();
            registrationHistory.setUserId(users.getUserId());
            registrationHistory.setUserName(users.getUsername());
            registrationHistory.setChannelId(users.getChannelId());
            registrationHistory.setTimestamp(users.getTimeStamp());
            registrationHistoryList.add(registrationHistory);
        }
        return registrationHistoryList;
    }
}
