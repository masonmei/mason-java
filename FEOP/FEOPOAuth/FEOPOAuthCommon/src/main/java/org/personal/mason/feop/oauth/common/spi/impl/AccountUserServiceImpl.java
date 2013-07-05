package org.personal.mason.feop.oauth.common.spi.impl;

import java.util.Date;
import java.util.List;

import org.personal.mason.feop.oauth.common.domain.AccountUser;
import org.personal.mason.feop.oauth.common.repository.AccountUserRepository;
import org.personal.mason.feop.oauth.common.spi.AccountUserService;
import org.personal.mason.feop.oauth.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountUserServiceImpl implements AccountUserService {

	private AccountUserRepository accountUserRepository;

	@Autowired
	public void setAccountUserRepository(AccountUserRepository accountUserRepository) {
		this.accountUserRepository = accountUserRepository;
	}

	public AccountUser findUserByUserId(String userId) {
		List<AccountUser> accountUsers = accountUserRepository.findByUserId(userId);
		return accountUsers.isEmpty() ? null : accountUsers.get(0);
	}

	public List<AccountUser> findUsersByBirth(Date date) {
		String birthMonthAndDay = DateUtils.getMonthAndDay(date);
		return accountUserRepository.findByBirthMonthDay(birthMonthAndDay);
	}

}
