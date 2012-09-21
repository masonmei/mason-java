package org.personal.mason.restful.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.personal.mason.restful.domain.Account;
import org.personal.mason.restful.rest.util.AccountActivityManager;
import org.personal.mason.restful.spi.AccountManager;

@Path("account")
public class AccountResource {
private AccountManager accountManager;
private AccountActivityManager accountActivityManager;

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
}
