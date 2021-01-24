package com.project2.registration.controller;

import com.project2.registration.entity.*;
import com.project2.registration.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
//todo : split the controller based on the domain models like login / registration, moderator add, followers add etc..  do the same for the services layer as well
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("save")
    UserData addUser(@RequestBody Users users){
        return registrationService.addUser(users);
    }

    @GetMapping("login/{channelId}/{email}/{password}")
    UserData findByEmailAndPassword(@PathVariable int channelId, @PathVariable String email, @PathVariable String password){
        return registrationService.findByChannelIdAndEmailAndPassword(channelId,email,password);
    }

    @PostMapping("update/{urlImg}")
    Users updateData(@PathVariable String imgUrl){
        return registrationService.updateData(imgUrl);
    }

}
