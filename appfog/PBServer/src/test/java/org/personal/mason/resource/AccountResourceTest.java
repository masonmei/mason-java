package org.personal.mason.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.personal.mason.domain.pb.Account;
import org.personal.mason.domain.pb.Basicinfo;
import org.personal.mason.domain.pb.Relation;
import org.personal.mason.utils.RestClient;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource.Builder;

public class AccountResourceTest {

/**
 * 
 */
@Test
public void testCreateAccount() {
	Account account = new Account();
	account.setEmail("mason.mei@gmai.com");
	account.setAccount("mason.mei@gmail.com");
	account.setSecret("rdisfun");
	account.setUsername("masonmei");
	account.setCreatedate(Calendar.getInstance().getTime());
	Builder accept = RestClient.getResource().path("/account/create").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
	try {
		Account post = accept.post(Account.class, account);
		assertEquals(account.getUsername(), post.getUsername());
		assertEquals(account.getEmail(), post.getEmail());
		assertEquals(account.getAccount(), post.getAccount());
		assertTrue(!account.getSecret().equals(post.getSecret()));
	} catch (UniformInterfaceException e) {
	} catch (ClientHandlerException e) {
	}
}

@Test
public void testValidateAccount() {
	Account account = new Account();
	account.setEmail("mason.mei@gmai.com");
	account.setAccount("mason.mei@gmail.com");
	account.setSecret("rdisfun");
	account.setUsername("masonmei");
	account.setCreatedate(Calendar.getInstance().getTime());
	Builder accept = RestClient.getResource().path("/account/validate").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
	try {
		Account post = accept.post(Account.class, account);
		assertEquals(account.getUsername(), post.getUsername());
		assertEquals(account.getEmail(), post.getEmail());
		assertEquals(account.getAccount(), post.getAccount());
		assertTrue(!account.getSecret().equals(post.getSecret()));
	} catch (UniformInterfaceException e) {
	} catch (ClientHandlerException e) {
	}
}

@Test
public void testModifyAccount() {
	Account account = new Account();
	account.setEmail("mason.mei@gmai.com");
	account.setAccount("mason.mei@gmail.com");
	account.setSecret("rdisfun");
	account.setUsername("masonmei");
	account.setCreatedate(Calendar.getInstance().getTime());
	Builder accept = RestClient.getResource().path("/account/validate").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
	try {
		ClientResponse response = accept.post(ClientResponse.class, account);
		List<String> list = response.getHeaders().get("Token");
		String token = list.get(0);
		Account entity = response.getEntity(Account.class);
		entity.setUsername("mason");
		Builder builder = RestClient.getResource().path("/account/modify").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		builder.header("Token", token);
		Account modifiedAccount = builder.put(Account.class, entity);
		assertEquals(modifiedAccount.getUsername(), "mason");
				
		Basicinfo info = new Basicinfo();
		info.setAddresses("GD");
		info.setBirth(Calendar.getInstance().getTime());
		info.setName("Mason Mei");	
		Relation relation = new Relation();
		relation.setBasicinfo(info);
		relation.setExtendinfo("extendinfo");
		relation.setRelationtype("relationtyps");
		entity.setRelation(relation);
		builder = RestClient.getResource().path("/account/modify").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		builder.header("Token", token);
		modifiedAccount = builder.put(Account.class, entity);
		assertEquals(modifiedAccount.getUsername(), "mason");
	} catch (UniformInterfaceException e) {
	} catch (ClientHandlerException e) {
	}
}

@Test
public void testChangePassword(){
	Account account = new Account();
	account.setEmail("mason.mei@gmai.com");
	account.setAccount("mason.mei@gmail.com");
	account.setSecret("rdisfun");
	account.setUsername("masonmei");
	account.setCreatedate(Calendar.getInstance().getTime());
	Builder accept = RestClient.getResource().path("/account/validate").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
	try {
		ClientResponse response = accept.post(ClientResponse.class, account);
		List<String> list = response.getHeaders().get("Token");
		String token = list.get(0);
		Account entity = response.getEntity(Account.class);
		entity.setUsername("mason");
		Builder builder = RestClient.getResource().path("/account/changePassword").queryParam("oldpassword", "rdisfun").queryParam("newpassword", "Rdis2fun").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		builder.header("Token", token);
		Account modifiedAccount = builder.get(Account.class);
		assertEquals(modifiedAccount.getUsername(), "mason");

		
	} catch (UniformInterfaceException e) {
	} catch (ClientHandlerException e) {
	}
}

@Test
public void testListAccounts() {
	Account account = new Account();
	account.setEmail("mason.mei@gmai.com");
	account.setAccount("mason.mei@gmail.com");
	account.setSecret("rdisfun");
	account.setUsername("masonmei");
	account.setCreatedate(Calendar.getInstance().getTime());
	Builder accept = RestClient.getResource().path("/account/validate").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
	try {
		ClientResponse response = accept.post(ClientResponse.class, account);
		List<String> list = response.getHeaders().get("Token");
		String token = list.get(0);
		Builder builder = RestClient.getResource().path("/account/list").queryParam("author", "mason mei").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		builder.header("Token", token);
		List<Account> result = builder.get(new GenericType<List<Account>>(){});
		assertTrue(result.size() > 0);
		
	} catch (UniformInterfaceException e) {
	} catch (ClientHandlerException e) {
	}
}

@Test
public void testIndex() {
	Builder accept = RestClient.getResource().path("/account/validate").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
	ClientResponse response = accept.get(ClientResponse.class);
	String entity = response.getEntity(String.class);
	System.out.println(entity);
}

}
