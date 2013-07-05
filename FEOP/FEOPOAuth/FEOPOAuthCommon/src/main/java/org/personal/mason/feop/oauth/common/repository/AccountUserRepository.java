package org.personal.mason.feop.oauth.common.repository;

import java.util.List;

import org.personal.mason.feop.oauth.common.data.FEOPJpaRepository;
import org.personal.mason.feop.oauth.common.domain.AccountUser;
import org.springframework.data.jpa.repository.Query;

public interface AccountUserRepository extends FEOPJpaRepository<AccountUser, Long> {

	@Query("From AccountUser Where userId = :userId")
	List<AccountUser> findByUserId(String userId);
	
	List<AccountUser> findByBirthMonthDay(String monthAndDay);
	
}
