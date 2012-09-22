package org.personal.mason.restful.resource;

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

import org.personal.mason.restful.domain.Account;
import org.personal.mason.restful.domain.Relation;
import org.personal.mason.restful.resource.util.AccountActivityManager;
import org.personal.mason.restful.spi.RelationManager;

@Path("relation")
public class RelationResource {

private RelationManager relationManager;

private AccountActivityManager accountActivityManager;

public void setRelationManager(RelationManager relationManager) {
	this.relationManager = relationManager;
}

public void setAccountActivityManager(AccountActivityManager accountActivityManager) {
	this.accountActivityManager = accountActivityManager;
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
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
@Path("/create")
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
@Path("/modify")
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
@Path("/delete/{id}")
public boolean deleteRelation(@PathParam("id") Long id, @HeaderParam("Token") String token) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if (account != null) {
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
		if (account != null) {
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
		if (account != null) {
			relationManager.deleteResource(id);
			return true;
		}
	} catch (Exception e) {
		return false;
	}
	return false;
}

}
