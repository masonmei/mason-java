package org.personal.mason.competition.service;

import java.util.List;

import org.jasypt.util.password.PasswordEncryptor;
import org.personal.mason.competition.domain.Account;
import org.personal.mason.competition.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

@Autowired
private AccountRepository accountRepository;

@Autowired
PasswordEncryptor passwordEncryptor;

public Account createAccount(Account account) {
	Account existAccount = accountRepository.findByEmailOrAccount(account.getEmail(), account.getAccount());

	if (existAccount == null) {
		account.setSecret(passwordEncryptor.encryptPassword(account.getSecret()));
		return accountRepository.save(account);
	}
	return null;
}

public Account validateAccount(Account account) {
    boolean result = false;
	Account findAccount = accountRepository.findByEmail(account.getEmail());
    if(findAccount != null){
        result = validatePassword(account.getSecret(), findAccount.getSecret());
    }
	if (!result) {
		findAccount = accountRepository.findByAccount(account.getAccount());
        if(findAccount != null){
            result =validatePassword(account.getSecret(), findAccount.getSecret());
        }
	}
    if(result){
	    return findAccount;
    }
    return null;
}

@Transactional
public Account modifyAccount(Account account) {
	Account persistEntity = accountRepository.findOne(account.getId());
	copyContent(account, persistEntity);
	return accountRepository.save(persistEntity);
}

@Transactional
public Account changePassword(Account account) {
	Account persistEntity = accountRepository.findOne(account.getId());
	persistEntity.setSecret(passwordEncryptor.encryptPassword(account.getSecret()));
	return accountRepository.save(persistEntity);
}

public List<Account> findAllAccounts() {
	return accountRepository.findAll();
}

public boolean validatePassword(String plainPassword, String encryptedPassword){
	return passwordEncryptor.checkPassword(plainPassword, encryptedPassword);
}

private static void copyContent(Account source, Account target){
	target.setAccount(source.getAccount());
	target.setCreatedate(source.getCreatedate());
	target.setEmail(source.getEmail());
	target.setUsername(source.getUsername());
}
}
