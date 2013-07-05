package org.personal.mason.feop.oauth.service.repository;

import java.util.List;

import org.personal.mason.feop.oauth.common.data.FEOPJpaRepository;
import org.personal.mason.feop.oauth.service.domain.OauthCode;

public interface OauthCodeRepository extends FEOPJpaRepository<OauthCode, Long> {
	List<OauthCode> findByCode(String code);
}
