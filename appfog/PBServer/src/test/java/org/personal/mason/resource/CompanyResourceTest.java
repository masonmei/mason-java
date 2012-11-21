package org.personal.mason.resource;

import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.personal.mason.domain.pb.Account;
import org.personal.mason.utils.RestClient;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource.Builder;

public class CompanyResourceTest {
public final static String token = loginForToken();

@Before
public void setUp() throws Exception {
}

private static String loginForToken() {
	Account account = new Account();
	account.setEmail("mason.mei@gmai.com");
	account.setAccount("mason.mei@gmail.com");
	account.setSecret("rdisfun");
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

@After
public void tearDown() throws Exception {
}

@Test
public void testListCompany() {

}

@Test
public void testDeleteCompany() {
	fail("Not yet implemented");
}

@Test
public void testViewCompany() {
	fail("Not yet implemented");
}

@Test
public void testNewCompany() {
	fail("Not yet implemented");
}

@Test
public void testAddLabelToCompany() {
	fail("Not yet implemented");
}

}
