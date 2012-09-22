package org.personal.mason.restful.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.personal.mason.restful.domain.Account;
import org.personal.mason.restful.resource.util.AccountActivityManager;
import org.personal.mason.restful.spi.AccountManager;

@Path("account")
public class AccountResource {

private AccountManager accountManager;

private AccountActivityManager accountActivityManager;

public void setAccountManager(AccountManager accountManager) {
	this.accountManager = accountManager;
}

public void setAccountActivityManager(AccountActivityManager accountActivityManager) {
	this.accountActivityManager = accountActivityManager;
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/create")
public Response createAccount(Account account) {
	Account savedAccount = accountManager.createAccount(account);
	String token = accountActivityManager.putAccount(savedAccount);
	return Response.ok(account).header("Token", token).build();
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/validate")
public Response validateAccount(Account account) {
	Account validateAccount = accountManager.validateAccount(account);
	String token = accountActivityManager.putAccount(validateAccount);
	if(token == null){
		return null;
	}
	return Response.ok(validateAccount).header("Token", token).build();
}

@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/modify")
public Response modifyAccount(Account account) {
	Account modifiedAccount = accountManager.modifyAccount(account);
	String token = accountActivityManager.putAccount(modifiedAccount);
	return Response.ok(modifiedAccount).header("Token", token).build();
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Account> listAccounts(@HeaderParam("Token") String token) {
	Account account = accountActivityManager.getAccount(token);
	if(account == null){
		return null;
	}
	return accountManager.findAllAccounts();
}
}
