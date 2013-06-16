package org.personal.mason.feop.oauth.service.spi;

import org.personal.mason.feop.oauth.service.domain.OauthClientDetail;

public interface OClientDetailService {

	OauthClientDetail findByClientId(String clientId);

}
