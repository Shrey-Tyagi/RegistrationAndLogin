package com.project2.registration.services.impl;

import com.project2.registration.entity.Users;
import com.project2.registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    RegistrationRepository registrationRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("In loadbyusername");
        System.out.println(s);
        int index = s.indexOf('*');
        String email = s.substring(0,index);
        System.out.println(email);
        String ch = s.substring(index+1);
        System.out.println(ch);
        int channel = Integer.parseInt(ch);
        Users users = registrationRepository.findByChannelIdAndEmail(channel, email);
        if (users == null) {
            throw new UsernameNotFoundException(users.getUsername());
        }
        UserDetails user = User.withUsername(users.getEmail()).password(users.getPassword()).authorities("USER").build();
        return user;
    }
}
