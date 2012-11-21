package org.personal.mason.resource;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.personal.mason.domain.pb.Account;
import org.personal.mason.domain.pb.Record;
import org.personal.mason.domain.pb.Relation;
import org.personal.mason.domain.pb.Resource;
import org.personal.mason.interceptor.AccountActivityManager;
import org.personal.mason.service.pb.RelationService;
import org.personal.mason.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/relation")
public class RelationResource {

@Autowired
private RelationService relationService;

@Autowired
private AccountActivityManager accountActivityManager;

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Relation> listRelations(@HeaderParam(Constants.REST_TOKEN_KEY) String token) {
	Account account = accountActivityManager.getAccount(token);
	if (account != null) {
		return relationService.listAllRelations(account);
	}
	return null;
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/create")
public Relation addRelation(Relation relation, @HeaderParam(Constants.REST_TOKEN_KEY) String token) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if (account != null) {
			Relation savedRelation = relationService.addRelation(relation, account);
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
public Relation modifyRelation(Relation relation, @HeaderParam(Constants.REST_TOKEN_KEY) String token) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if (account != null) {
			Relation modifyRelation = relationService.modifyRelation(relation);
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
public boolean deleteRelation(@PathParam("id") String id, @HeaderParam(Constants.REST_TOKEN_KEY) String token) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if (account != null) {
			return relationService.deleteRelation(id);
		}
	} catch (Exception e) {
		return false;
	}
	return false;
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/record/delete")
public boolean deleteRecord(@QueryParam("id") String id, @HeaderParam(Constants.REST_TOKEN_KEY) String token,
		@QueryParam("relation") String relationId) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if (account != null) {
			Relation relation = new Relation();
			relation.setId(relationId);
			return relationService.deleteRecord(id, relation);
		}
	} catch (Exception e) {
		return false;
	}
	return false;
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/record/create")
public Record addRecord(Record record, @HeaderParam(Constants.REST_TOKEN_KEY) String token,
		@QueryParam("relation") String relationId) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if (account != null) {
			Relation relation = new Relation();
			relation.setId(relationId);
			Record savedRecord = relationService.addRecord(record, relation);
			return savedRecord;
		}
		return null;
	} catch (Exception e) {
		return null;
	}
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/resource/delete")
public boolean deleteResource(@QueryParam("id") String id, @HeaderParam(Constants.REST_TOKEN_KEY) String token,
		@QueryParam("relation") String relationId) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if (account != null) {
			Relation relation = new Relation();
			relation.setId(relationId);
			relationService.deleteResource(id, relation);
			return true;
		}
	} catch (Exception e) {
		return false;
	}
	return false;
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/resource/create")
public Resource addResource(Resource resource, @HeaderParam(Constants.REST_TOKEN_KEY) String token,
		@QueryParam("relation") String relationId) {
	try {
		Account account = accountActivityManager.getAccount(token);
		if (account != null) {
			Relation relation = new Relation();
			relation.setId(relationId);
			Resource savedResource = relationService.addResource(resource, relation);
			return savedResource;
		}
		return null;
	} catch (Exception e) {
		return null;
	}
}
}
