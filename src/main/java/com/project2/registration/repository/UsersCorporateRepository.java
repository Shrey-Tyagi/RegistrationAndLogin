package com.project2.registration.repository;

import com.project2.registration.entity.UsersCorporate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersCorporateRepository extends CrudRepository<UsersCorporate,String> {

    UsersCorporate findByChannelIdAndUserId(int channelId, String userId);
}

