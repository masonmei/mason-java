package org.personal.mason.restful.spi;

import java.util.List;

import org.personal.mason.restful.dao.IDAO;
import org.personal.mason.restful.domain.Account;
import org.personal.mason.restful.domain.Basicinfo;
import org.personal.mason.restful.domain.Relation;
import org.springframework.transaction.annotation.Transactional;

// @Service(value="accountManager")
public class AccountManager {

private IDAO<Account> accountDao;
private IDAO<Relation> relationDao;
private IDAO<Basicinfo> basicInfoDao;

public void setAccountDao(IDAO<Account> accountDao) {
	this.accountDao = accountDao;
}

public void setRelationDao(IDAO<Relation> relationDao) {
	this.relationDao = relationDao;
}

public void setBasicInfoDao(IDAO<Basicinfo> basicInfoDao) {
	this.basicInfoDao = basicInfoDao;
}

@Transactional
public Account createAccount(Account account) {
	List<Account> findBy = accountDao.findByExample(account);

	if (findBy == null || findBy.isEmpty()) {
		Relation relation = account.getRelation();
		if (relation != null) {
			Basicinfo basicinfo = relation.getBasicinfo();

			basicInfoDao.save(basicinfo);
			relationDao.save(relation);
		}
		accountDao.save(account);

		return account;
	}
	return null;
}

@Transactional(readOnly = true)
public Account validateAccount(Account account) {
	List<Account> findByExamples = accountDao.findByExample(account);
	if (findByExamples.isEmpty()) {
		return null;
	}
	return findByExamples.get(0);
}

@Transactional
public Account modifyAccount(Account account) {
	Relation relation = account.getRelation();
	if (relation != null) {
		Basicinfo basicinfo = relation.getBasicinfo();
		if (null != basicinfo) {
			basicInfoDao.udpate(basicinfo);
		}
		relationDao.udpate(relation);
	}
	accountDao.udpate(account);

	return account;
}

@Transactional(readOnly=true)
public List<Account> findAllAccounts() {
	
	return accountDao.findAll();
}

}
