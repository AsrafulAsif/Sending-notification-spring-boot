package com.example.sendingnotification.repository;

import com.example.sendingnotification.entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<AppUser,String> {
}
