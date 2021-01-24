package com.project2.registration.repository;

import com.project2.registration.entity.ModeratorsCorporate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorsCorporateRepository extends CrudRepository<ModeratorsCorporate, String> {

    ModeratorsCorporate findByChannelIdAndUserId(int channelId, String userId);
}
