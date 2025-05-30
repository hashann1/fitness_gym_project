package com.example.backend.Repository;

import com.example.backend.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String username);
    User findByEmail(String email);
}
