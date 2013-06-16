package org.personal.mason.feop.oauth.service.spi;

import java.io.Serializable;
import java.util.List;

import org.personal.mason.feop.oauth.service.domain.OauthUser;
import org.personal.mason.feop.oauth.service.mvc.model.SignupForm;
import org.springframework.transaction.annotation.Transactional;

public interface OUserService {

	public void update(OauthUser user);

	@Transactional
	public void regist(OauthUser user);

	public OauthUser findUserById(Serializable id);

	/**
	 * Query User by email or username
	 * 
	 * @param emailOrUsername
	 * @return
	 */
	public OauthUser findByEmailOrUsername(String emailOrUsername);

	/**
	 * Query user Roles
	 * 
	 * @param user
	 * @return
	 */
	public List<String> findUserRoles(OauthUser user);

	public OauthUser createUser(SignupForm signupForm);
}
