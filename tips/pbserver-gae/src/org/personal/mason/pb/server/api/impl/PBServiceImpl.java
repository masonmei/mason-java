package org.personal.mason.pb.server.api.impl;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.personal.mason.pb.server.api.PBService;
import org.personal.mason.pb.server.api.model.PBAccount;
import org.personal.mason.pb.server.api.model.PBRelation;
import org.personal.mason.pb.server.api.service.IAccountActivityManager;
import org.personal.mason.pb.server.api.service.impl.AccountActivityManager;
import org.personal.mason.pb.server.domain.Account;
import org.personal.mason.pb.server.domain.Relation;
import org.personal.mason.pb.server.service.IAccountManager;
import org.personal.mason.pb.server.service.IRelationManager;
import org.personal.mason.pb.server.service.IServiceProxy;
import org.personal.mason.pb.server.service.impl.ServiceProxy;
import org.personal.mason.pb.server.utils.ModelConvetor;

public class PBServiceImpl implements PBService {
private IRelationManager relationManager;
private IAccountManager accountManager;
private IAccountActivityManager activityManager;

public PBServiceImpl() {
	IServiceProxy proxy = new ServiceProxy();
	relationManager = proxy.getProxiedRelationManager();
	accountManager = proxy.getProxiedAccountManager();
	activityManager = new AccountActivityManager();
	activityManager.run();
}

@Override
public PBAccount createAccount(PBAccount account, HttpServletResponse response) {
	Account createAccount = accountManager.createAccount(ModelConvetor.unConvertAccount(account));
	PBAccount convertAccount = ModelConvetor.convertAccount(createAccount);
	String token = activityManager.putAccount(convertAccount);
	response.addHeader("Token", token);
	return convertAccount;
}

@Override
public PBAccount validateAccount(PBAccount account, HttpServletResponse response) {
	PBAccount convertAccount = ModelConvetor.convertAccount(accountManager.validateAccount(ModelConvetor.unConvertAccount(account)));
	String token = activityManager.putAccount(convertAccount);
	response.addHeader("Token", token);
	return convertAccount;
}

@Override
public PBAccount modifyAccount(PBAccount account, HttpServletResponse response) {
	PBAccount convertAccount = ModelConvetor.convertAccount(accountManager.modifyAccount(ModelConvetor.unConvertAccount(account)));
	String token = activityManager.putAccount(convertAccount);
	response.addHeader("Token", token);
	return convertAccount;
}

@Override
public Set<PBRelation> listRelations(String token) {
	PBAccount account = activityManager.getAccount(token);
	if (account != null) {
		Account acc = ModelConvetor.unConvertAccount(account);
		return ModelConvetor.convertRelations(relationManager.listAllRelations(acc));
	}
	return null;
}

@Override
public PBRelation addRelation(PBRelation relation, String token) {
	try {
		PBAccount account = activityManager.getAccount(token);
		if (account != null) {
			Relation unConvertRelation = ModelConvetor.unConvertRelation(relation, ModelConvetor.lazyUnConvertAccount(account));
			Relation addRelation = relationManager.addRelation(unConvertRelation);
			return ModelConvetor.convertRelation(addRelation);
		}
		return null;
	} catch (Exception e) {
		return null;
	}
}

@Override
public PBRelation modifyRelation(PBRelation relation, String token) {
	try {
		PBAccount account = activityManager.getAccount(token);
		if (account != null) {
			Relation modifyRelation = relationManager.modifyRelation(ModelConvetor.unConvertRelation(relation, ModelConvetor.lazyUnConvertAccount(account)));
			return ModelConvetor.convertRelation(modifyRelation);
		}
		return null;
	} catch (Exception e) {
		return null;
	}
}

@Override
public boolean deleteRelation(Long id, String token) {
	try {
		activityManager.updateAccountActivity(token);
		return relationManager.deleteRelation(id);
	} catch (Exception e) {
		return false;
	}
}

@Override
public boolean deleteRecord(Long id, String token) {
	try {
		activityManager.updateAccountActivity(token);
		return relationManager.deleteRecord(id);
	} catch (Exception e) {
		return false;
	}
}

@Override
public boolean deleteResource(Long id, String token) {
	try {
		activityManager.updateAccountActivity(token);
		relationManager.deleteResource(id);
		return true;
	} catch (Exception e) {
		return false;
	}
}

@Override
public Set<PBRelation> getRelations(String type, String value, String token) {
	String lctype = type.toLowerCase().trim();
	PBAccount account = activityManager.getAccount(token);
	if (account != null) {
		Account acc = ModelConvetor.unConvertAccount(account);
		if (lctype.equals("name")) {
			return ModelConvetor.convertRelations(relationManager.getRelationsByName(acc, value));
		} else if (lctype.equals("cellphone")) {
			return ModelConvetor.convertRelations(relationManager.getRelationsByCellPhone(acc, value));
		} else if (lctype.equals("phone")) {
			return ModelConvetor.convertRelations(relationManager.getRelationsByPhone(acc, value));
		} else if (lctype.equals("contact")) {
			return ModelConvetor.convertRelations(relationManager.getRelationsByContact(acc, value));
		} else if (lctype.equals("accomplishment")) {
			return ModelConvetor.convertRelations(relationManager.getRelationsByAccomplishment(acc, value));
		} else if (lctype.equals("recorddesc")) {
			return ModelConvetor.convertRelations(relationManager.getRelationsByPersonalRecordDes(acc, value));
		} else if (lctype.equals("resourcedesc")) {
			return ModelConvetor.convertRelations(relationManager.getRelationsByResourceDes(acc, value));
		}
	}
	return null;
}

@Override
public Set<PBRelation> getRelations(String type, String title, String value, String token) {
	String lctype = type.toLowerCase().trim();
	PBAccount account = activityManager.getAccount(token);
	if (account != null) {
		if (lctype.equals("accomplishment")) {
			return ModelConvetor.convertRelations(relationManager.getRelationsByTypeAndAccomplishment(ModelConvetor.unConvertAccount(account), title, value));
		} else if (lctype.equals("recorddesc")) {
			return ModelConvetor
			        .convertRelations(relationManager.getRelationsByTypeAndPersonalRecordDes(ModelConvetor.unConvertAccount(account), title, value));
		}
	}
	return null;
}

}
