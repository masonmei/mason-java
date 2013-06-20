package org.personal.mason.feop.oauth.service.spi;

import org.personal.mason.feop.oauth.service.domain.OauthClientDetail;

public interface OClientDetailService {

	OauthClientDetail findByClientId(String clientId);

	void decorateClientBy(OauthClientDetail client, String clientType);

	void createApplication(OauthClientDetail client);

}
