package org.personal.mason.demo.repository;

import org.personal.mason.demo.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created with IntelliJ IDEA.
 * User: masonmei
 * Date: 11/3/12
 * Time: 1:44 AM
 * To change this template use File | Settings | File Templates.
 */
public interface RoleRepository extends MongoRepository<Role, String> {
}
