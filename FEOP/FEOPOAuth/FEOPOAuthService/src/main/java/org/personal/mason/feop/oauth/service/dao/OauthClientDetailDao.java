package org.personal.mason.feop.oauth.service.dao;

import org.personal.mason.feop.oauth.service.domain.OauthClientDetail;

public interface OauthClientDetailDao extends GenericDao<OauthClientDetail> {

	/**
	 * 保存客户端
	 * 
	 * @param client
	 *            客户端对象
	 * @return
	 */
	public boolean saveClient(OauthClientDetail client);

	/**
	 * 查询客户端
	 * 
	 * @param clientId
	 *            客户端ID
	 * @return
	 */
	public OauthClientDetail findByClientId(String clientId);

}
