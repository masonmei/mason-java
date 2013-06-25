package org.personal.mason.feop.oauth.service.dao;

import org.personal.mason.feop.oauth.service.domain.OauthClientDetail;

public interface OauthClientDetailDao extends GenericDao<OauthClientDetail> {

	public boolean saveClient(OauthClientDetail client);

	public OauthClientDetail findByClientId(String clientId);

	public void updateApplication(OauthClientDetail oauthClientDetail);

}
