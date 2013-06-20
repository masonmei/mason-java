package org.personal.mason.feop.oauth.service.spi.impl;

import org.personal.mason.feop.oauth.service.dao.OauthClientDetailDao;
import org.personal.mason.feop.oauth.service.domain.OauthClientDetail;
import org.personal.mason.feop.oauth.service.spi.OClientDetailService;
import org.springframework.beans.factory.annotation.Autowired;

public class OClientDetailServiceImpl implements OClientDetailService {

	private OauthClientDetailDao oauthClientDetailDao;

	@Autowired
	public void setOauthClientDetailDao(OauthClientDetailDao oauthClientDetailDao) {
		if (oauthClientDetailDao == null) {
			throw new IllegalArgumentException("client detail dao cannot be null");
		}
		this.oauthClientDetailDao = oauthClientDetailDao;
	}

	@Override
	public OauthClientDetail findByClientId(String clientId) {
		return oauthClientDetailDao.findByClientId(clientId);
	}

	@Override
	public void decorateClientBy(OauthClientDetail client, String clientTypeName) {
		ClientTypes clientType = ClientTypes.getClientTypeWithName(clientTypeName);
		client.setScope(clientType.getScope());
		client.setAuthorizedGrantTypes(clientType.getGrantTypes());
		client.setAuthorities(clientType.getAuthorities());
		client.setAccessTokenValidity(clientType.getAccessTokenValidity());
		client.setRefreshTokenValidity(clientType.getRefreshTokenValidity());
	}

	@Override
	public void createApplication(OauthClientDetail client) {
		oauthClientDetailDao.saveClient(client);
	}

}
