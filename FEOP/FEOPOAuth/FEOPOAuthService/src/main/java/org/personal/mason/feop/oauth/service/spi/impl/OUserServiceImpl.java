package org.personal.mason.feop.oauth.service.spi.impl;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.personal.mason.feop.oauth.service.dao.OauthUserDao;
import org.personal.mason.feop.oauth.service.domain.OauthUser;
import org.personal.mason.feop.oauth.service.mvc.model.SignupForm;
import org.personal.mason.feop.oauth.service.spi.OUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class OUserServiceImpl implements OUserService {
	private OauthUserDao userDao;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setUserDao(OauthUserDao userDao) {
		if (userDao == null) {
			throw new IllegalArgumentException("user dao cannot be null");
		}
		this.userDao = userDao;
	}

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		if (passwordEncoder == null) {
			throw new IllegalArgumentException(
					"password encoder cannot be null");
		}
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional
	public void update(OauthUser user) {
		throw new NotImplementedException();
	}

	@Override
	@Transactional
	public void regist(OauthUser user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userDao.saveObject(user);
	}

	@Override
	public OauthUser findUserById(Serializable id) {
		return userDao.getObject(OauthUser.class, id);
	}

	@Override
	public OauthUser findByEmailOrUsername(String emailOrUsername) {
		return userDao.findByEmailOrUsername(emailOrUsername);
	}

	@Override
	public List<String> findUserRoles(OauthUser user) {
		return userDao.findUserRoles(user);
	}

	@Override
	public OauthUser createUser(SignupForm signupForm) {
		OauthUser user = new OauthUser();
		user.setActivated(true);
		user.setEmail(signupForm.getEmail());
		user.setPassword(signupForm.getPassword());
		user.setUserId(UUID.randomUUID().toString());
		user.setUserName(String.format("%s %s", signupForm.getFirstName(),
				signupForm.getLastName()).trim());
		return user;
	}

}
