package org.personal.mason.pb.server.service.impl;

import java.util.Arrays;
import java.util.List;

import org.personal.mason.pb.server.dao.DAOFactory;
import org.personal.mason.pb.server.dao.IDAO;
import org.personal.mason.pb.server.domain.Account;
import org.personal.mason.pb.server.domain.Basicinfo;
import org.personal.mason.pb.server.domain.Relation;
import org.personal.mason.pb.server.service.IAccountManager;

public class AccountManager implements IAccountManager {
private IDAO<Account> accountDao = DAOFactory.getDAO(Account.class);
private IDAO<Relation> relationDao = DAOFactory.getDAO(Relation.class);
private IDAO<Basicinfo> basicInfoDao = DAOFactory.getDAO(Basicinfo.class);

@Override
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

@Override
public Account validateAccount(Account account) {
	List<Account> query = accountDao.query(Account.class, "(email=? OR account=?) AND secret=?", Arrays.asList(new Object[] { account.getEmail(),
	        account.getAccount(), account.getSecret() }));
	if (query.isEmpty()) {
		return null;
	}
	return query.get(0);
}

@Override
public Account modifyAccount(Account account) {
	Relation relation = account.getRelation();
	if(relation != null){
		Basicinfo basicinfo = relation.getBasicinfo();
		if(null != basicinfo){
			basicInfoDao.saveOrUpdate(basicinfo);
		}
		relationDao.saveOrUpdate(relation);
	}
	Account result = accountDao.saveOrUpdate(account);
	
	return result;
}

}
