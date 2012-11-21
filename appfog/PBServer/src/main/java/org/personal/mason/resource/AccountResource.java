package org.personal.mason.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.personal.mason.domain.pb.Account;
import org.personal.mason.interceptor.AccountActivityManager;
import org.personal.mason.service.pb.AccountService;
import org.personal.mason.service.pb.RelationService;
import org.personal.mason.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Path("/account")
public class AccountResource {

@Autowired
private AccountService accountService;

@Autowired
private RelationService relationService;

@Autowired
private AccountActivityManager accountActivityManager;

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/create")
public Response createAccount(Account account) {
	Account savedAccount = accountService.createAccount(account);
	String token = accountActivityManager.putAccount(savedAccount);if (token == null) {
		return Response.ok(null).build();
	}
	return Response.ok(savedAccount).header(Constants.REST_TOKEN_KEY, token).build();
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/validate")
public Response validateAccount(Account account) {
	Account validateAccount = accountService.validateAccount(account);
	String token = accountActivityManager.putAccount(validateAccount);
	if (token == null) {
		return Response.ok(null).build();
	}
	return Response.ok(validateAccount).header(Constants.REST_TOKEN_KEY, token).build();
}

@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/modify")
public Account modifyAccount(@HeaderParam(Constants.REST_TOKEN_KEY) String token, Account account) {
	Account sessionAccount = accountActivityManager.getAccount(token);
	if(sessionAccount == null){
		return null;
	}
	Account modifiedAccount = accountService.modifyAccount(account);
	if(modifiedAccount == null){
		return null;
	}
	accountActivityManager.updateSessionAccount(token, modifiedAccount);
	return modifiedAccount;
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/changePassword")
public Account changePassword(@HeaderParam(Constants.REST_TOKEN_KEY) String token, @QueryParam("oldpassword") String oldPassword, @QueryParam("newpassword") String newPassword){
	Account account = accountActivityManager.getAccount(token);
	if(account != null && accountService.validatePassword(oldPassword, account.getSecret())){
		account.setSecret(newPassword);
		Account modifiedAccount = accountService.changePassword(account);
		if(modifiedAccount != null){
			accountActivityManager.updateSessionAccount(token, modifiedAccount);
		}
		return modifiedAccount;
	}
	return null;
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Account> listAccounts(@HeaderParam(Constants.REST_TOKEN_KEY) String token, @QueryParam("author") String builderName) {
	if (builderName.equals("mason mei")) {
		Account account = accountActivityManager.getAccount(token);
		if (account == null) {
			return null;
		}
		return accountService.findAllAccounts();
	}
	return null;
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/index")
public String index() {
	return "Please Login First";
}
}
