package org.personal.mason.feop.oauth.service.repository;

import java.util.List;

import org.personal.mason.feop.oauth.common.data.FEOPJpaRepository;
import org.personal.mason.feop.oauth.service.domain.OauthRefreshToken;

public interface OauthRefreshTokenRepository extends FEOPJpaRepository<OauthRefreshToken, Long> {

	List<OauthRefreshToken> findByTokenId(String tokenid);

}
