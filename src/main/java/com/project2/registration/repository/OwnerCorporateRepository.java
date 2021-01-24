package com.project2.registration.repository;

import com.project2.registration.entity.OwnersCorporate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerCorporateRepository extends CrudRepository<OwnersCorporate, String> {
    OwnersCorporate save(OwnersCorporate ownersCorporate);

    OwnersCorporate findByChannelIdAndUserId(int channelId, String userId);
}
