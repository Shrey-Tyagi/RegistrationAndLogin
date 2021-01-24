package com.project2.registration.controller;

import com.project2.registration.entity.*;
import com.project2.registration.models.AuthenticationRequest;
import com.project2.registration.models.AuthenticationResponse;
import com.project2.registration.services.RegistrationService;
import com.project2.registration.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
//todo : split the controller based on the domain models like login / registration, moderator add, followers add etc..  do the same for the services layer as well
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtil;

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


    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        if(authenticationRequest.getOauth()!=-1 && (registrationService.findByChannelIdAndEmail(authenticationRequest.getOauth(),authenticationRequest.getEmail())!=null)
                &&(registrationService.findByChannelIdAndEmail(authenticationRequest.getChannelId(),authenticationRequest.getEmail())==null)){
            Users userToSave = registrationService.findByChannelIdAndEmail(authenticationRequest.getOauth(), authenticationRequest.getEmail());
            Users userFinal = new Users();
            userFinal.setChannelId(authenticationRequest.getChannelId());
            userFinal.setUserId(userToSave.getUserId());
            userFinal.setEmail(userToSave.getEmail());
            userFinal.setPassword(userToSave.getPassword());
            UserData newUser = registrationService.saveUser(userFinal);
            System.out.println("if exit");
        }
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail()+"*"+authenticationRequest.getChannelId(), authenticationRequest.getPassword()));
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect email or password", e);
        }
//        String s = authenticationRequest.getEmail() + "*0";
//        System.out.println((s));
//        final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(authenticationRequest.getEmail()+"*0");
        Users users = new Users();
        users = registrationService.findByChannelIdAndEmail(authenticationRequest.getChannelId(),authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(users);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
