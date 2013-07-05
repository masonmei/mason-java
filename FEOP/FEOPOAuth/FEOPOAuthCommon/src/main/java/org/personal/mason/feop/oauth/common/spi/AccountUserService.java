package org.personal.mason.feop.oauth.common.spi;

import java.util.Date;
import java.util.List;

import org.personal.mason.feop.oauth.common.domain.AccountUser;

public interface AccountUserService {

	AccountUser findUserByUserId(String userId);
	
	List<AccountUser> findUsersByBirth(Date date);
	
}
