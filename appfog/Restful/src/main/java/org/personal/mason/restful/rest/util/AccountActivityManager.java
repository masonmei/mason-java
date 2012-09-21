package org.personal.mason.restful.rest.util;

import java.util.concurrent.TimeUnit;

import org.personal.mason.restful.domain.Account;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class AccountActivityManager {

private LoadingCache<String, Account> sessionCache = CacheBuilder.newBuilder().expireAfterAccess(30, TimeUnit.MINUTES)
        .build(new CacheLoader<String, Account>() {
	        @Override
	        public Account load(String key) throws Exception {
		        return null;
	        }
        });

public AccountActivityManager() {
	super();
}

public String putAccount(Account account) {
	try {
		String token = TokenGenerator.generateToken(account);
		sessionCache.put(token, account);
		return token;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

public Account getAccount(String token) {
	return sessionCache.apply(token);
}

public void removeAccount(String token) {
	sessionCache.refresh(token);
}

}
