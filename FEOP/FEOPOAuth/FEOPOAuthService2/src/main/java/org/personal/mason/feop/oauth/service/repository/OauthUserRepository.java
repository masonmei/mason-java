package org.personal.mason.feop.oauth.service.repository;

import java.util.List;

import org.personal.mason.feop.oauth.common.data.FEOPJpaRepository;
import org.personal.mason.feop.oauth.service.domain.OauthUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OauthUserRepository extends FEOPJpaRepository<OauthUser, Long> {

	@Query("From OauthUser Where email = :ctx Or userName = :ctx")
	List<OauthUser> findByUserNameOrEmail(@Param("ctx") String compareStr);
	
}
