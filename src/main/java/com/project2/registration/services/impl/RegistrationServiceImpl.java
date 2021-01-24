package com.project2.registration.services.impl;

import com.project2.registration.entity.*;
import com.project2.registration.repository.CorporateRepository;
import com.project2.registration.repository.RegistrationRepository;
import com.project2.registration.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    CorporateRepository corporateRepository;

    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    Pattern pattern = Pattern.compile(regex);

    @Override
    public UserData addUser(UserDTO userDTO) {
        List<Users> userExistList =  registrationRepository.findByEmail(userDTO.getEmail());

        Users  checkEmailExist =  registrationRepository.findByChannelIdAndEmail(userDTO.getChannelId(),userDTO.getEmail());
        Users  checkUsernameExist = registrationRepository.findByChannelIdAndUsername(userDTO.getChannelId(),userDTO.getUsername());

        UserData userData = new UserData();
        userData.setProfileImage("-1");
        userData.setUserId("-1");
        userData.setUsername("-1");


        if(!(checkEmailExist == null)) {
            userData.setCode(100);
            return userData;
        }else if (!(checkUsernameExist == null)){
            userData.setCode(101);
            return userData;
        }else if(userDTO.getPassword() == null){
            userData.setCode(102);
            return userData;
        }else if(!(pattern.matcher(userDTO.getEmail()).matches())){
            userData.setCode(103);
            return userData;
        }else {
            if(userExistList.size() == 0){
                userDTO.setUserId(randomStringGenerator());
            }else {
                Users userExist = userExistList.get(0);
                 {
                     userDTO.setUserId(userExist.getUserId());
                }
            }///userId,username,timestamp,channelId
            Users users = new Users();
            users.setName(userDTO.getName());
            users.setDateOfBirth(userDTO.getDateOfBirth());
            users.setBio(userDTO.getBio());
            users.setUserId(userDTO.getUserId());
            users.setMobileNumber(userDTO.getMobileNumber());
            users.setUsername(userDTO.getUsername());
            users.setAreaOfInterests(userDTO.getAreaOfInterests());
            users.setProfileImage(userDTO.getProfileImage());
            users.setCorporateEntity(userDTO.isCorporateEntity());
            users.setMaster(userDTO.isMaster());
            users.setType(userDTO.isType());
            users.setNotificationToken(userDTO.getNotificationToken());
            users.setChannelId(userDTO.getChannelId());
            users.setEmail(userDTO.getEmail());
            users.setPassword(userDTO.getPassword());

            registrationRepository.save(users);
            userData.setProfileImage(users.getProfileImage());
            userData.setUserId(users.getUserId());
            userData.setUsername(users.getUsername());
            return userData;
        }
    }


    @Override
    public UserData findByChannelIdAndEmailAndPassword(int channelId, String email, String password) {
        Users user = registrationRepository.findByChannelIdAndEmailAndPassword(channelId,email,password);
        UserData userLoginData = new UserData();
        if(user == null){
            userLoginData.setProfileImage("-1");
            userLoginData.setUserId("-1");
            userLoginData.setUsername("-1");
        }
        else{
            userLoginData.setProfileImage(user.getProfileImage());
            userLoginData.setUserId(user.getUserId());
            userLoginData.setUsername(user.getUsername());
        }
        return userLoginData;

    }

    @Override
    public UserDTO updateData(UserDTO userDTO) {
        Users users = registrationRepository.findByChannelIdAndEmail(userDTO.getChannelId(),userDTO.getEmail());
        ///To do waiting for token and oauth sorting
        if(userDTO.getBio()!=null){
            users.setBio(userDTO.getBio());
        }
        if(userDTO.getDateOfBirth()!=null){
            users.setDateOfBirth((userDTO.getDateOfBirth()));
        }
        if(userDTO.getMobileNumber()!= 0){
            users.setMobileNumber((userDTO.getMobileNumber()));
        }
        if(userDTO.getName()!=null){
            users.setName((userDTO.getName()));
        }
        if(userDTO.getUsername()!=null){
            users.setUsername((userDTO.getUsername()));
        }
        registrationRepository.save(users);
        return userDTO;


    }

    @Override
    public UserData loginMaster(int channelId, String email, String password) {
        Users user = registrationRepository.findByChannelIdAndEmailAndPassword(channelId, email, password);
        UserData userLoginData = new UserData();
        if (user.isMaster()) {
            if (user == null) {
                userLoginData.setProfileImage("-1");
                userLoginData.setUserId("-1");
                userLoginData.setUsername("-1");
            } else {
                userLoginData.setProfileImage(user.getProfileImage());
                userLoginData.setUserId(user.getUserId());
                userLoginData.setUsername(user.getUsername());
            }
        }
            return userLoginData;

    }

    public String randomStringGenerator() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
