package org.techtask.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techtask.entity.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

}
