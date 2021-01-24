package com.project2.registration.repository;

import com.project2.registration.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends CrudRepository<Users,String> {
    Users findByChannelIdAndEmailAndPassword(int channelId, String email, String password);

    List<Users> findByEmail(String email);

    Users findByChannelIdAndEmail(int channelId, String email);

    Users findByChannelIdAndUsername(int channelId, String username);



}
