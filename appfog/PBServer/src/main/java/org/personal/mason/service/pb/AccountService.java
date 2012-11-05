package org.personal.mason.service.pb;

import java.util.List;

import org.jasypt.util.password.PasswordEncryptor;
import org.personal.mason.domain.pb.Account;
import org.personal.mason.domain.pb.Relation;
import org.personal.mason.repository.pb.AccountRepository;
import org.personal.mason.repository.pb.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

@Autowired
private AccountRepository accountRepository;

@Autowired
private RelationRepository relationRepository;

@Autowired
PasswordEncryptor passwordEncryptor;

public Account createAccount(Account account) {
	Account existAccount = accountRepository.findByEmailOrAccount(account.getEmail(), account.getAccount());

	if (existAccount == null) {
		if (account.getRelation() != null) {
			Relation savedRelation = relationRepository.save(account.getRelation());
			account.setRelation(savedRelation);
		}
		return accountRepository.save(account);
	}
	return null;
}

public Account validateAccount(Account account) {
	account.setSecret(passwordEncryptor.encryptPassword(account.getSecret()));
	Account findAccount;
	findAccount = accountRepository.findByEmailAndSecret(account.getEmail(), account.getSecret());

	if (findAccount == null) {
		findAccount = accountRepository.findByAccountAndSecret(account.getAccount(), account.getSecret());
	}

	return findAccount;
}

@Transactional
public Account modifyAccount(Account account) {
	Relation relation = account.getRelation();
	if (relation != null) {
		relationRepository.save(account.getRelation());
	}
	return accountRepository.save(account);
}

public List<Account> findAllAccounts() {
	return accountRepository.findAll();
}
}
