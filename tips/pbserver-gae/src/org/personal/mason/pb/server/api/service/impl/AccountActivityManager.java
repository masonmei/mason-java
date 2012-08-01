package org.personal.mason.pb.server.api.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import org.personal.mason.pb.server.api.model.PBAccount;
import org.personal.mason.pb.server.api.service.IAccountActivityManager;
import org.personal.mason.pb.server.api.service.util.TokenGenerator;
import org.personal.mason.pb.server.conf.PropertyConfig;

public class AccountActivityManager implements IAccountActivityManager {

private Map<String, Entry<PBAccount, Date>> map = new HashMap<String, Entry<PBAccount, Date>>();
private long expireTime;
private long schedule;
private Object LOCKER = new Object(); 

public AccountActivityManager() {
	super();
	Properties configProp = PropertyConfig.getConfigProp();
	String expire = configProp.getProperty("ACCOUNTEXPIRETIME", "1800");
	Long et = Long.parseLong(expire);
	expireTime = et == null ? 1800 * 1000 * 1000 : et * 1000 * 1000;
	
	String scheduleString = configProp.getProperty("ACCOUNTACTIVITYMANAGEMENTSCHEDULE", "60");
	Long sche = Long.parseLong(scheduleString);
	schedule = sche == null ? 60 * 1000 * 1000 : sche * 1000 * 1000;
	
}

@Override
public String putAccount(PBAccount account) {
	try {
		String token = TokenGenerator.generateToken(account);
		Date date = Calendar.getInstance().getTime();
		Entry<PBAccount, Date> entry = new Entry<PBAccount, Date>(account, date);
		map.put(token, entry);
		return token;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

@Override
public PBAccount getAccount(String token) {
	updateAccountActivity(token);
	Entry<PBAccount, Date> entry = map.get(token);
	if (entry != null) {
		return entry.getKey();
	}
	return null;
}

@Override
public void updateAccountActivity(String token) {
	Entry<PBAccount, Date> entry = map.get(token);
	if (entry != null) {
		entry.setValue(Calendar.getInstance().getTime());
	}
}

@Override
public void removeAccount(String token) {
	map.remove(token);
}

@Override
public void run() {
	final Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		@Override
		public void run() {
			long timestamp = Calendar.getInstance().getTimeInMillis();
			synchronized (LOCKER) {
				for (java.util.Map.Entry<String, Entry<PBAccount, Date>> entry : map.entrySet()) {
					if (entry.getValue().getValue().getTime() + expireTime <= timestamp) {
						map.remove(entry.getKey());
					}
				}
				
				timer.schedule(this, schedule);
            }
		}
	};
	
	timer.schedule(task, schedule);
}

class Entry<K, V> implements java.util.Map.Entry<K, V> {
private K key;
private V value;

public Entry(K key, V value) {
	super();
	this.key = key;
	this.value = value;
}

@Override
public K getKey() {
	return key;
}

@Override
public V getValue() {
	return value;
}

@Override
public V setValue(V value) {
	this.value = value;
	return this.value;
}

}

}
