package com.project2.registration.controller;

import com.project2.registration.entity.*;
import com.project2.registration.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
//todo : split the controller based on the domain models like login / registration, moderator add, followers add etc..  do the same for the services layer as well
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("save")
    UserData addUser(@RequestBody UserDTO userDTO){
        return registrationService.addUser(userDTO);
    }

    @GetMapping("login/{channelId}/{email}/{password}")
    UserData findByEmailAndPassword(@PathVariable int channelId, @PathVariable String email, @PathVariable String password){
        return registrationService.findByChannelIdAndEmailAndPassword(channelId,email,password);
    }

    @PostMapping("update")
    UserDTO updateData(@RequestBody UserDTO userDTO){
        return registrationService.updateData(userDTO);
    }

    @GetMapping("login/master/{channelId}/{email}/{password}")
    UserData loginMaster(@PathVariable int channelId, @PathVariable String email, @PathVariable String password){
        return registrationService.loginMaster(channelId,email,password);
    }

}
