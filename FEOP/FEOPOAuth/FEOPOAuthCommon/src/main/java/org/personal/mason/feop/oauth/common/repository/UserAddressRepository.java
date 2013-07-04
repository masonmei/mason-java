package org.personal.mason.feop.oauth.common.repository;

import org.personal.mason.feop.oauth.common.domain.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

}
