package org.personal.mason.feop.oauth.service.repository;

import org.personal.mason.feop.oauth.service.domain.OauthCode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.String;
import java.util.List;

public interface OauthCodeRepository extends JpaRepository<OauthCode, Long> {
	List<OauthCode> findByCode(String code);
}
