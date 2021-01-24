package com.project2.registration.services;

import com.project2.registration.entity.LoginHistory;
import com.project2.registration.entity.RegistrationHistory;

import java.util.List;

public interface LoginHistoryService {
    LoginHistory save(LoginHistory loginHistory);

    List<LoginHistory> findAll();

    List<RegistrationHistory> findAllRegistrationData();

}
