package org.personal.mason.feop.oauth.service.spi.impl;

import java.util.List;

import org.personal.mason.feop.oauth.service.dao.OauthClientDetailDao;
import org.personal.mason.feop.oauth.service.domain.OauthClientDetail;
import org.personal.mason.feop.oauth.service.spi.OClientDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
	@Transactional
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
	@Transactional
	public void createApplication(OauthClientDetail client) {
		oauthClientDetailDao.saveClient(client);
	}

	@Override
	@Transactional
	public void updateApplication(OauthClientDetail oauthClientDetail) {
		oauthClientDetailDao.updateApplication(oauthClientDetail);
	}

	@Override
	@Transactional
	public void deleteApplication(OauthClientDetail oauthClientDetail) {
		oauthClientDetailDao.removeObject(oauthClientDetail);
	}

	@Override
	@Transactional
	public List<OauthClientDetail> findAllOauthClientDetails() {
		return oauthClientDetailDao.findAll();
	}

}
