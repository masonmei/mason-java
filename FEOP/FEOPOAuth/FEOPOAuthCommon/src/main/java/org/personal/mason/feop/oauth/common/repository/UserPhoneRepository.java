package org.personal.mason.feop.oauth.common.repository;

import org.personal.mason.feop.oauth.common.domain.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPhoneRepository extends JpaRepository<UserPhone, Long> {

}
