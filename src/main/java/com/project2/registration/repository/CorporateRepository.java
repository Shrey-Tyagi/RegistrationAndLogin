package com.project2.registration.repository;

import com.project2.registration.entity.Corporate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateRepository extends CrudRepository<Corporate, String> {

    Corporate findByChannelIdAndPageIdAndRole(int channelId, String pageId, String role);
}