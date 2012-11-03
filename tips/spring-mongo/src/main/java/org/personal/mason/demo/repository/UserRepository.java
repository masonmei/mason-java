package org.personal.mason.demo.repository;

import org.personal.mason.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created with IntelliJ IDEA.
 * User: masonmei
 * Date: 11/3/12
 * Time: 1:43 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
