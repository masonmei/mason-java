package org.personal.mason.pb.server.api.service.impl;

import java.util.Properties;

import org.personal.mason.pb.server.api.cache.CacheStore;
import org.personal.mason.pb.server.api.model.PBAccount;
import org.personal.mason.pb.server.api.service.IAccountActivityManager;
import org.personal.mason.pb.server.api.service.util.TokenGenerator;
import org.personal.mason.pb.server.conf.PropertyConfig;

public class AccountActivityManager implements IAccountActivityManager {

private Integer expireTime;

public AccountActivityManager() {
	super();
	Properties configProp = PropertyConfig.getConfigProp();
	String expire = configProp.getProperty("ACCOUNTEXPIRETIME", "1800");
	Integer et = Integer.parseInt(expire);
	expireTime = et == null ? 1800 : et;
}

@Override
public String putAccount(PBAccount account) {
	try {
		String token = TokenGenerator.generateToken(account);
		CacheStore.syncPut(token, account, expireTime);
		return token;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

@Override
public PBAccount getAccount(String token) {
	return CacheStore.syncGet(PBAccount.class, token);
}

@Override
public void removeAccount(String token) {
	CacheStore.syncRemove(token);
}

}
