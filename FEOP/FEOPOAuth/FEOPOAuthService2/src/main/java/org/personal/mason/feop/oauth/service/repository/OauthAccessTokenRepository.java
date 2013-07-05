package org.personal.mason.feop.oauth.service.repository;

import java.util.List;

import org.personal.mason.feop.oauth.common.data.FEOPJpaRepository;
import org.personal.mason.feop.oauth.service.domain.OauthAccessToken;

public interface OauthAccessTokenRepository extends FEOPJpaRepository<OauthAccessToken, Long> {
	List<OauthAccessToken> findByTokenId(String tokenid);

	List<OauthAccessToken> findByRefreshToken(String refreshtoken);

	List<OauthAccessToken> findByAuthenticationId(String authenticationid);

	List<OauthAccessToken> findByClientId(String clientid);

	List<OauthAccessToken> findByUserName(String username);
}
