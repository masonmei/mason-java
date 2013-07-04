package org.personal.mason.feop.oauth.common.repository;

import org.personal.mason.feop.oauth.common.domain.UserResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResourceRepository extends JpaRepository<UserResource, Long> {

}
