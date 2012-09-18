package org.personal.mason.restful.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.personal.mason.restful.domain.Account;
import org.personal.mason.restful.domain.Relation;
import org.personal.mason.restful.spi.AccountManager;
import org.personal.mason.restful.spi.RelationManager;

@Path("pbservice")
public class PBServiceImpl{
private RelationManager relationManager;
private AccountManager accountManager;
private AccountActivityManager accountActivityManager = new AccountActivityManager();

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/account/create")
public Response createAccount(Account account) {
	Account savedAccount = accountManager.createAccount(account);
	String token = accountActivityManager.putAccount(savedAccount);
	return Response.ok(account).header("Token", token).build();
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/account/validate")
public Response validateAccount(Account account) {
	Account validateAccount = accountManager.validateAccount(account);
	String token = accountActivityManager.putAccount(validateAccount);
	return Response.ok(account).header("Token", token).build();
}

@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/account/modify")
public Response modifyAccount(Account account) {
	Account modifiedAccount = accountManager.modifyAccount(account);
	String token = accountActivityManager.putAccount(modifiedAccount);
	return Response.ok(account).header("Token", token).build();
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/list")
public List<Relation> listRelations(@HeaderParam("Token") String token) {
	Account account = accountActivityManager.getAccount(token);
	if (account != null) {
		return relationManager.listAllRelations(account);
	}
	return null;
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/add")
public Relation addRelation(Relation relation, @HeaderParam("Token") String token) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if (account != null) {
			Relation savedRelation = relationManager.addRelation(relation);
			return savedRelation;
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
public Relation modifyRelation(Relation relation, @HeaderParam("Token") String token) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if (account != null) {
			Relation modifyRelation = relationManager.modifyRelation(relation);
			return modifyRelation;
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
		Account account = accountActivityManager.getAccount(token);
		if(account != null){
			return relationManager.deleteRelation(id);
		}
	} catch (Exception e) {
		return false;
	}
	return false;
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/record/delete/{id}")
public boolean deleteRecord(@PathParam("id") Long id, @HeaderParam("Token") String token) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if(account != null){
			return relationManager.deleteRecord(id);
		}
	} catch (Exception e) {
		return false;
	}
	return false;
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/resource/delete/{id}")
public boolean deleteResource(@PathParam("id") Long id, @HeaderParam("Token") String token) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if(account != null){
			relationManager.deleteResource(id);
			return true;
		}
	} catch (Exception e) {
		return false;
	}
	return false;
}

//@GET
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//@Path("/relation/retrieve/{type}/{value}")
//public Set<Relation> getRelations(@PathParam("type") String type, @PathParam("value") String value, @HeaderParam("Token") String token) {
//	String lctype = type.toLowerCase().trim();
//	Account account = activityManager.getAccount(token);
//	if (account != null) {
//		Account acc = ModelConvetor.unConvertAccount(account);
//		if (lctype.equals("name")) {
//			return ModelConvetor.convertRelations(relationManager.getRelationsByName(acc, value));
//		} else if (lctype.equals("cellphone")) {
//			return ModelConvetor.convertRelations(relationManager.getRelationsByCellPhone(acc, value));
//		} else if (lctype.equals("phone")) {
//			return ModelConvetor.convertRelations(relationManager.getRelationsByPhone(acc, value));
//		} else if (lctype.equals("contact")) {
//			return ModelConvetor.convertRelations(relationManager.getRelationsByContact(acc, value));
//		} else if (lctype.equals("accomplishment")) {
//			return ModelConvetor.convertRelations(relationManager.getRelationsByAccomplishment(acc, value));
//		} else if (lctype.equals("recorddesc")) {
//			return ModelConvetor.convertRelations(relationManager.getRelationsByPersonalRecordDes(acc, value));
//		} else if (lctype.equals("resourcedesc")) {
//			return ModelConvetor.convertRelations(relationManager.getRelationsByResourceDes(acc, value));
//		}
//	}
//	return null;
//}
//
//@GET
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//@Path("/relation/retrieve/{type}")
//public Set<Relation> getRelations(@PathParam("type") String type, @QueryParam("title") String title, @QueryParam("value") String value,
//        @HeaderParam("Token") String token) {
//	String lctype = type.toLowerCase().trim();
//	Account account = activityManager.getAccount(token);
//	if (account != null) {
//		if (lctype.equals("accomplishment")) {
//			return ModelConvetor.convertRelations(relationManager.getRelationsByTypeAndAccomplishment(ModelConvetor.unConvertAccount(account), title, value));
//		} else if (lctype.equals("recorddesc")) {
//			return ModelConvetor
//			        .convertRelations(relationManager.getRelationsByTypeAndPersonalRecordDes(ModelConvetor.unConvertAccount(account), title, value));
//		}
//	}
//	return null;
//}

}
