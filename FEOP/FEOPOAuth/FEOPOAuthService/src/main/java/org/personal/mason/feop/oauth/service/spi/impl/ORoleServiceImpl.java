package org.personal.mason.feop.oauth.service.spi.impl;

import java.util.List;

import org.personal.mason.feop.oauth.service.dao.OauthRoleDao;
import org.personal.mason.feop.oauth.service.domain.OauthRole;
import org.personal.mason.feop.oauth.service.spi.ORoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class ORoleServiceImpl implements ORoleService {

	private OauthRoleDao roleDao;

	@Autowired
	public void setRoleDao(OauthRoleDao roleDao) {
		if (roleDao == null) {
			throw new IllegalArgumentException("auth Role Dao cannot be null");
		}
		this.roleDao = roleDao;
	}

	@Override
	public List<OauthRole> getDefaultUserRoles() {
		return roleDao.getDefaultUserRoles();
	}

}
