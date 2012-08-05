package org.personal.mason.pb.server.api.service;

import org.personal.mason.pb.server.api.model.PBAccount;

public interface IAccountActivityManager{

	public String putAccount(PBAccount account);
	public PBAccount getAccount(String token);
	public void removeAccount(String token);
	
}
