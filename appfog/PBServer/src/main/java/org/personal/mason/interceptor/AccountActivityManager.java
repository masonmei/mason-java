package org.personal.mason.interceptor;

import java.util.concurrent.TimeUnit;

import org.personal.mason.domain.pb.Account;
import org.personal.mason.utils.TokenGenerator;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
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
		if(account == null ) return null;
		String token = TokenGenerator.generateToken();
		sessionCache.put(token, account);
		return token;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

public Account getAccount(String token) {
	if(token == null || token.isEmpty()){
		return null;
	}
	return sessionCache.apply(token);
}

public void updateSessionAccount(String token, Account account){
	sessionCache.put(token, account);
}

public void removeAccount(String token) {
	sessionCache.refresh(token);
}

}
