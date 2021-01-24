package com.project2.registration.services.impl;

import com.project2.registration.entity.*;
import com.project2.registration.repository.ModeratorsCorporateRepository;
import com.project2.registration.repository.OwnerCorporateRepository;
import com.project2.registration.repository.RegistrationRepository;
import com.project2.registration.repository.UsersCorporateRepository;
import com.project2.registration.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    RegistrationRepository registrationRepository;
    @Autowired
    OwnerCorporateRepository ownerCorporateRepository;
    @Autowired
    UsersCorporateRepository usersCorporateRepository;
    @Autowired
    ModeratorsCorporateRepository moderatorsCorporateRepository;

    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    Pattern pattern = Pattern.compile(regex);

    @Override
    public UserData addUser(Users users) {
        List<Users> userExistList =  registrationRepository.findByEmail(users.getEmail());

        Users  checkEmailExist =  registrationRepository.findByChannelIdAndEmail(users.getChannelId(),users.getEmail());
        Users  checkUsernameExist = registrationRepository.findByChannelIdAndUsername(users.getChannelId(),users.getUsername());

        UserData userData = new UserData();
        userData.setProfileImage("-1");
        userData.setUserId("-1");
        userData.setUsername("-1");
        userData.setUserToken("-1");

        if(!(checkEmailExist == null)) {
            userData.setCode(100);
            return userData;
        }else if (!(checkUsernameExist == null)){
            userData.setCode(101);
            return userData;
        }else if(users.getPassword() == null){
            userData.setCode(102);
            return userData;
        }else if(!(pattern.matcher(users.getEmail()).matches())){
            userData.setCode(103);
            return userData;
        }else {
            if(userExistList.size() == 0){
                users.setUserId(randomStringGenerator());
            }else {
                Users userExist = userExistList.get(0);
                 {
                    users.setUserId(userExist.getUserId());
                }
            }
            registrationRepository.save(users);
            userData.setProfileImage(users.getProfileImage());
            userData.setUserId(users.getUserId());
            userData.setUsername(users.getUsername());
            userData.setUserToken(users.getUserToken());
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
            userLoginData.setUserToken("-1");
        }
        else{
            userLoginData.setProfileImage(user.getProfileImage());
            userLoginData.setUserId(user.getUserId());
            userLoginData.setUsername(user.getUsername());
            userLoginData.setUserToken(user.getUserToken());
        }
        return userLoginData;

    }

    @Override
    public Users updateData(String imgUrl) {
        return null;///To do waiting for token and oauth sorting
    }

    @Override
    public OwnersCorporate addOwnerData(OwnersCorporate ownersCorporate) {
        return ownerCorporateRepository.save(ownersCorporate);
    }

    @Override
    public UsersCorporate addUsersData(UsersCorporate usersCorporate) {
        return usersCorporateRepository.save(usersCorporate);
    }

    @Override
    public ModeratorsCorporate addModeratorsData(ModeratorsCorporate moderatorsCorporate) {
        return moderatorsCorporateRepository.save(moderatorsCorporate);
    }

    @Override
    public OwnersCorporate findByChannelIdAndUserIdOwner(int channelId, String userId) {
        return ownerCorporateRepository.findByChannelIdAndUserId(channelId,userId);
    }

    @Override
    public ModeratorsCorporate findByChannelIdAndUserIdModerator(int channelId, String userId) {
        return moderatorsCorporateRepository.findByChannelIdAndUserId(channelId,userId);
    }

    @Override
    public UsersCorporate findByChannelIdAndUserIdUsers(int channelId, String userId) {
        return usersCorporateRepository.findByChannelIdAndUserId(channelId,userId);
    }

    @Override
    public UsersCorporate updateUserData(UsersCorporate usersCorporate) {
        UsersCorporate usersCorporateData = usersCorporateRepository.findByChannelIdAndUserId(usersCorporate.getChannelId(),usersCorporate.getUserId());
        if(usersCorporateData == null){
            return usersCorporateRepository.save(usersCorporate);
        }
        else{
            usersCorporate.setUsersId(usersCorporateData.getUsersId()+','+ usersCorporate.getUsersId());
            return usersCorporateRepository.save(usersCorporate);
        }

    }

    @Override
    public ModeratorsCorporate updateModeratorsData(ModeratorsCorporate moderatorsCorporate) {
        ModeratorsCorporate moderatorsCorporateData = moderatorsCorporateRepository.findByChannelIdAndUserId(moderatorsCorporate.getChannelId(),moderatorsCorporate.getUserId());
        if(moderatorsCorporateData == null){
            return moderatorsCorporateRepository.save(moderatorsCorporate);
        }
        else{
            moderatorsCorporate.setModeratorId(moderatorsCorporateData.getModeratorId()+','+ moderatorsCorporate.getModeratorId());
            return moderatorsCorporateRepository.save(moderatorsCorporate);
        }
    }

    @Override
    public OwnersCorporate updateOwnerData(OwnersCorporate ownersCorporate) {
        OwnersCorporate ownersCorporateData = ownerCorporateRepository.findByChannelIdAndUserId(ownersCorporate.getChannelId(),ownersCorporate.getUserId());
        if(ownersCorporateData == null){
            return ownerCorporateRepository.save(ownersCorporate);
        }
        else{
            ownersCorporate.setOwnerId(ownersCorporateData.getOwnerId()+','+ ownersCorporate.getOwnerId());
            return ownerCorporateRepository.save(ownersCorporate);
        }
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
