package org.personal.mason.feop.oauth.account.rest;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.personal.mason.feop.oauth.account.domain.AccountUser;
import org.personal.mason.feop.oauth.account.domain.UserAddress;
import org.personal.mason.feop.oauth.account.domain.UserEmail;
import org.personal.mason.feop.oauth.account.domain.UserIM;
import org.personal.mason.feop.oauth.account.domain.UserPhone;
import org.personal.mason.feop.oauth.account.domain.UserRecord;
import org.personal.mason.feop.oauth.account.domain.UserResource;
import org.personal.mason.feop.oauth.account.spi.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/")
public class AccountResource {

	private AccountUserService accountUserService;

	@Autowired
	public void setAccountUserService(AccountUserService accountUserService) {
		this.accountUserService = accountUserService;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/save")
	public AccountUser createAccount(AccountUser accountUser) {
		accountUserService.createAccount(accountUser);
		return accountUser;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/update")
	public AccountUser updateAccount(AccountUser accountUser) {
		return accountUserService.updateAccount(accountUser);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}")
	public AccountUser findAccount(@PathParam("id") Long id) {
		return accountUserService.findById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account")
	public AccountUser findAccountWithUserId(@QueryParam("userid") String userId) {
		return accountUserService.findUserByUserId(userId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/address/default")
	public UserAddress getDefaultAddress(@PathParam("id") Long id) {
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/addresses")
	public List<UserAddress> getAddresses(@PathParam("id") Long id) {
		return Collections.emptyList();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/address/save")
	public UserAddress addAddress(@PathParam("id") Long id, UserAddress userAddress) {
		return userAddress;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/address/delete")
	public int deleteAddress(@PathParam("id") Long id, @QueryParam("id") Long addressId) {
		return 0;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/address/update")
	public UserAddress updateAddress(@PathParam("id") Long id, UserAddress address) {
		return address;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/address/update")
	public boolean setDefaultAddress(@PathParam("id") Long id, @QueryParam("id") Long addressId) {
		return false;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/mail/default")
	public UserEmail getDefaultEmail(@PathParam("id") Long id) {
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/emails")
	public List<UserEmail> getEmails(@PathParam("id") Long id) {
		return Collections.emptyList();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/email/save")
	public UserEmail addEmail(@PathParam("id") Long id, UserEmail userEmail) {
		return userEmail;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/email/delete")
	public int deleteEmail(@PathParam("id") Long id, @QueryParam("id") Long emailId) {
		return 0;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/email/update")
	public UserEmail updateEmail(@PathParam("id") Long id, UserEmail userEmail) {
		return userEmail;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/email/update")
	public boolean setDefaultEmail(@PathParam("id") Long id, @QueryParam("id") Long emailId) {
		return false;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/phone/default")
	public UserPhone getDefaultPhone(@PathParam("id") Long id) {
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/phones")
	public List<UserPhone> getPhones(@PathParam("id") Long id) {
		return Collections.emptyList();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/phone/save")
	public UserPhone addPhone(@PathParam("id") Long id, UserPhone userPhone) {
		return userPhone;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/phone/delete")
	public int deletePhone(@PathParam("id") Long id, @QueryParam("id") Long phoneId) {
		return 0;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/phone/update")
	public UserPhone updatePhone(@PathParam("id") Long id, UserPhone userPhone) {
		return userPhone;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/phone/update")
	public boolean setDefaultPhone(@PathParam("id") Long id, @QueryParam("id") Long phoneId) {
		return false;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/record/default")
	public UserRecord getDefaultRecord(@PathParam("id") Long id) {
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/records")
	public List<UserRecord> getRecords(@PathParam("id") Long id) {
		return Collections.emptyList();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/record/save")
	public UserRecord addRecord(@PathParam("id") Long id, UserRecord userRecord) {
		return userRecord;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/record/delete")
	public int deleteRecord(@PathParam("id") Long id, @QueryParam("id") Long recordId) {
		return 0;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/record/update")
	public UserRecord updateRecord(@PathParam("id") Long id, UserRecord userRecord) {
		return userRecord;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/record/update")
	public boolean setDefaultRecord(@PathParam("id") Long id, @QueryParam("id") Long recordId) {
		return false;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/resource/default")
	public UserResource getDefaultResource(@PathParam("id") Long id) {
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/resources")
	public List<UserResource> getResources(@PathParam("id") Long id) {
		return Collections.emptyList();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/resource/save")
	public UserResource addResource(@PathParam("id") Long id, UserResource userResource) {
		return userResource;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/resource/delete")
	public int deleteResource(@PathParam("id") Long id, @QueryParam("id") Long resourceId) {
		return 0;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/resource/update")
	public UserResource updateResource(@PathParam("id") Long id, UserResource userResource) {
		return userResource;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/resource/update")
	public boolean setDefaultResource(@PathParam("id") Long id, @QueryParam("id") Long resourceId) {
		return false;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/im/default")
	public UserIM getDefaultIM(@PathParam("id") Long id) {
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/ims")
	public List<UserIM> getIMs(@PathParam("id") Long id) {
		return Collections.emptyList();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/im/save")
	public UserIM addIM(@PathParam("id") Long id, UserIM userIM) {
		return userIM;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/im/delete")
	public int deleteIM(@PathParam("id") Long id, @QueryParam("id") Long imId) {
		return 0;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/im/update")
	public UserIM updateIM(@PathParam("id") Long id, UserIM userIM) {
		return userIM;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/account/{id}/im/update")
	public boolean setDefaultIM(@PathParam("id") Long id, @QueryParam("id") Long imId) {
		return false;
	}
}
