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

    @PostMapping("owners")
    OwnersCorporate addOwnerData(@RequestBody OwnersCorporate ownersCorporate){
        return registrationService.addOwnerData(ownersCorporate);
    }

    @PostMapping("users")
    UsersCorporate addUsersData(@RequestBody UsersCorporate usersCorporate){
        return registrationService.addUsersData(usersCorporate);
    }

    @PostMapping("moderators")
    ModeratorsCorporate addModeratorsData(@RequestBody ModeratorsCorporate moderatorsCorporate){
        return registrationService.addModeratorsData(moderatorsCorporate);
    }


    @GetMapping("ownersData/{channelId}/{userId}")
    OwnersCorporate showOwnerData(@PathVariable int channelId , @PathVariable String userId){
        return registrationService.findByChannelIdAndUserIdOwner(channelId,userId);
    }

    @GetMapping("moderateData/{channelId}/{userId}")
    ModeratorsCorporate showModerateData(@PathVariable int channelId, @PathVariable String userId){
        return registrationService.findByChannelIdAndUserIdModerator(channelId,userId);
    }

    @GetMapping("userData/{channelId}/{userId}")
    UsersCorporate showUserData(@PathVariable int channelId, @PathVariable String userId){
        return registrationService.findByChannelIdAndUserIdUsers(channelId,userId);
    }

    @GetMapping("userDataUpdate")
    UsersCorporate updateUserData(@RequestBody UsersCorporate usersCorporate){
        return registrationService.updateUserData(usersCorporate);
    }

    @GetMapping("userModeratorUpdate")
    ModeratorsCorporate updateModeratorsData(@RequestBody ModeratorsCorporate moderatorsCorporate){
        return registrationService.updateModeratorsData(moderatorsCorporate);
    }

    @GetMapping("userOwnerUpdate")
    OwnersCorporate updateOwnerData(@RequestBody OwnersCorporate ownersCorporate){
        return registrationService.updateOwnerData(ownersCorporate);
    }


}
