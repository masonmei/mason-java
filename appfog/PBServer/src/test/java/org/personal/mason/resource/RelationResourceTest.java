package org.personal.mason.resource;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.personal.mason.domain.pb.Account;
import org.personal.mason.domain.pb.Relation;
import org.personal.mason.utils.RestClient;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource.Builder;

public class RelationResourceTest {
public final static String token = loginForToken();

@Before
public void setUp() throws Exception {
}

@After
public void tearDown() throws Exception {
}

private static String loginForToken() {
	Account account = new Account();
	account.setEmail("mason.mei@gmai.com");
	account.setAccount("mason.mei@gmail.com");
	account.setSecret("Rdis2fun");
	account.setUsername("masonmei");
	account.setCreatedate(Calendar.getInstance().getTime());
	Builder accept = RestClient.getResource().path("/account/validate").type(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	try {
		ClientResponse response = accept.post(ClientResponse.class, account);
		List<String> list = response.getHeaders().get("Token");
		return list.get(0);
	} catch (UniformInterfaceException e) {
	} catch (ClientHandlerException e) {
	}
	return null;
}

@Test
public void testListRelations() {
	String path = "/relation/list";
	Builder builder = RestClient.getResource().path(path).type(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	builder.header("Token", token);
	List<Relation> result = builder.get(new GenericType<List<Relation>>() {
	});
	assertTrue(result.size() == 0);
}

@Test
public void testAddRelation() {
	fail("Not yet implemented");
}

@Test
public void testModifyRelation() {
	fail("Not yet implemented");
}

@Test
public void testDeleteRelation() {
	fail("Not yet implemented");
}

@Test
public void testDeleteRecord() {
	fail("Not yet implemented");
}

@Test
public void testAddRecord() {
	fail("Not yet implemented");
}

@Test
public void testDeleteResource() {
	fail("Not yet implemented");
}

@Test
public void testAddResource() {
	fail("Not yet implemented");
}

}
