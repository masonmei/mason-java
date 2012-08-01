package org.personal.mason.pb.server.api.service;

import org.personal.mason.pb.server.api.model.PBAccount;

public interface IAccountActivityManager extends Runnable{

	public String putAccount(PBAccount account);
	public PBAccount getAccount(String token);
	public void updateAccountActivity(String token);
	public void removeAccount(String token);
	
}
