package com.project2.registration.repository;

import com.project2.registration.entity.LoginHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginHistoryRepository extends MongoRepository<LoginHistory, String> {

}
