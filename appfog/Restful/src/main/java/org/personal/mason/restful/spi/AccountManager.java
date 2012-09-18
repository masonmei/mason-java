package org.personal.mason.restful.spi;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.restful.dao.DAO;
import org.personal.mason.restful.dao.IDAO;
import org.personal.mason.restful.domain.Account;
import org.personal.mason.restful.domain.Basicinfo;
import org.personal.mason.restful.domain.Relation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountManager {
private EntityManager entityManager;

@PersistenceContext
private void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

private IDAO<Account> accountDao = new DAO<Account>(entityManager);
private IDAO<Relation> relationDao = new DAO<Relation>(entityManager);
private IDAO<Basicinfo> basicInfoDao = new DAO<Basicinfo>(entityManager);

@Transactional
public Account createAccount(Account account) {
	List<Account> findByEmail = accountDao.getBy(Account.class, "email", account.getEmail());
	List<Account> findByAccount = accountDao.getBy(Account.class, "account", account.getAccount());

	if (findByEmail.isEmpty() && findByAccount.isEmpty()) {
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
	List<Account> query = accountDao.query(Account.class, "(email=? OR account=?) AND secret=?", Arrays.asList(new Object[] { account.getEmail(),
	        account.getAccount(), account.getSecret() }));
	if (query.isEmpty()) {
		return null;
	}
	return query.get(0);
}


@Transactional
public Account modifyAccount(Account account) {
	Relation relation = account.getRelation();
	if (relation != null) {
		Basicinfo basicinfo = relation.getBasicinfo();
		if (null != basicinfo) {
			basicInfoDao.saveOrUpdate(basicinfo);
		}
		relationDao.saveOrUpdate(relation);
	}
	Account result = accountDao.saveOrUpdate(account);

	return result;
}

}
