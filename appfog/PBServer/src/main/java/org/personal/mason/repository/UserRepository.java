package org.personal.mason.repository;

import org.personal.mason.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

User findByEmail(String email);

User findByPassword(String password);
}
