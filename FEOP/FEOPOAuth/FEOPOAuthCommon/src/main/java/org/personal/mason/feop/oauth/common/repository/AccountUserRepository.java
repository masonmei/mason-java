package org.personal.mason.feop.oauth.common.repository;

import java.util.List;

import org.personal.mason.feop.oauth.common.domain.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {

	@Query("From AccountUser Where userId = :userId")
	List<AccountUser> findByUserId(String userId);
	
	
}
