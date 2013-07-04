package org.personal.mason.feop.oauth.common.repository;

import org.personal.mason.feop.oauth.common.domain.UserEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEmailRepository extends JpaRepository<UserEmail, Long> {

}
