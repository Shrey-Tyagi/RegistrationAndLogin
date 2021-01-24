package com.project2.registration.controller;

import com.project2.registration.entity.LoginHistory;
import com.project2.registration.entity.RegistrationHistory;
import com.project2.registration.services.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/History")
public class HistoryController {

    @Autowired
    LoginHistoryService loginHistoryService;

    @GetMapping("/getLoginHistory")
    public List<LoginHistory> findAll(){
        return loginHistoryService.findAll();
    }

    @GetMapping("/getRegistrationHistory")
    public List<RegistrationHistory> findAllRegistrationData(){
        return loginHistoryService.findAllRegistrationData();
    }


}
