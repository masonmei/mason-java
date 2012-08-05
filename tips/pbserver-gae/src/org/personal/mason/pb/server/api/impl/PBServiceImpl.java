package org.personal.mason.pb.server.api.impl;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

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

@Path("/pbservice/")
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

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/account/create")
public PBAccount createAccount(PBAccount account, @Context HttpServletResponse response) {
	Account createAccount = accountManager.createAccount(ModelConvetor.unConvertAccount(account));
	PBAccount convertAccount = ModelConvetor.convertAccount(createAccount);
	String token = activityManager.putAccount(convertAccount);
	response.addHeader("Token", token);
	return convertAccount;
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/account/validate")
public PBAccount validateAccount(PBAccount account, @Context HttpServletResponse response) {
	PBAccount convertAccount = ModelConvetor.convertAccount(accountManager.validateAccount(ModelConvetor.unConvertAccount(account)));
	String token = activityManager.putAccount(convertAccount);
	response.addHeader("Token", token);
	return convertAccount;
}

@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/account/modify")
public PBAccount modifyAccount(PBAccount account, @Context HttpServletResponse response) {
	PBAccount convertAccount = ModelConvetor.convertAccount(accountManager.modifyAccount(ModelConvetor.unConvertAccount(account)));
	String token = activityManager.putAccount(convertAccount);
	response.addHeader("Token", token);
	return convertAccount;
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/list")
public Set<PBRelation> listRelations(@HeaderParam("Token") String token) {
	PBAccount account = activityManager.getAccount(token);
	if (account != null) {
		Account acc = ModelConvetor.unConvertAccount(account);
		return ModelConvetor.convertRelations(relationManager.listAllRelations(acc));
	}
	return null;
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/add")
public PBRelation addRelation(PBRelation relation, @HeaderParam("Token") String token) {
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

@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/modify")
public PBRelation modifyRelation(PBRelation relation, @HeaderParam("Token") String token) {
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

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/delete/{id}")
public boolean deleteRelation(@PathParam("id") Long id, @HeaderParam("Token") String token) {
	try {
		activityManager.updateAccountActivity(token);
		return relationManager.deleteRelation(id);
	} catch (Exception e) {
		return false;
	}
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/record/delete/{id}")
public boolean deleteRecord(@PathParam("id") Long id, @HeaderParam("Token") String token) {
	try {
		activityManager.updateAccountActivity(token);
		return relationManager.deleteRecord(id);
	} catch (Exception e) {
		return false;
	}
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/resource/delete/{id}")
public boolean deleteResource(@PathParam("id") Long id, @HeaderParam("Token") String token) {
	try {
		activityManager.updateAccountActivity(token);
		relationManager.deleteResource(id);
		return true;
	} catch (Exception e) {
		return false;
	}
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/retrieve/{type}/{value}")
public Set<PBRelation> getRelations(@PathParam("type") String type, @PathParam("value") String value, @HeaderParam("Token") String token) {
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

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/retrieve/{type}")
public Set<PBRelation> getRelations(@PathParam("type") String type, @QueryParam("title") String title, @QueryParam("value") String value,
        @HeaderParam("Token") String token) {
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
