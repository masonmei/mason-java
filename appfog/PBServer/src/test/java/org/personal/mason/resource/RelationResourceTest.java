package org.personal.mason.resource;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.personal.mason.domain.pb.Account;
import org.personal.mason.domain.pb.Basicinfo;
import org.personal.mason.domain.pb.Record;
import org.personal.mason.domain.pb.Relation;
import org.personal.mason.domain.pb.Resource;
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
	assertTrue(result.size() == 2);
	for (Relation relation : result) {
		System.out.println(relation.getId());
	}
}

@Test
public void testAddRelation() {
	String path = "/relation/create";
	Relation relation = new Relation();
	Basicinfo info = new Basicinfo();
	info.setAddresses("GD");
	info.setBirth(Calendar.getInstance().getTime());
	info.setName("Mason Mei");
	relation.setBasicinfo(info);
	relation.setExtendinfo("extendinfo");
	relation.setRelationtype("relationtyps");

	Builder builder = RestClient.getResource().path(path).type(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	builder.header("Token", token);
	Relation result = null;
	try {
		result = builder.post(Relation.class, relation);
	} catch (UniformInterfaceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClientHandlerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertNotNull(result);
}

@Test
public void testModifyRelation() {
	String path = "/relation/modify";
	Relation relation = new Relation();
	relation.setId("50acec690364e521c4b10c2d");
	Basicinfo info = new Basicinfo();
	info.setAddresses("GD1");
	info.setBirth(Calendar.getInstance().getTime());
	relation.setBasicinfo(info);
	relation.setExtendinfo("extendinfo1");
	relation.setRelationtype("relationtyps1");
	Builder builder = RestClient.getResource().path(path).type(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	builder.header("Token", token);
	Relation result = null;
	try {
		result = builder.put(Relation.class, relation);
	} catch (UniformInterfaceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClientHandlerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertNotNull(result);
}

@Test
public void testDeleteRelation() {
	String path = "/relation/delete";
	Builder builder = RestClient.getResource().path(path).queryParam("id", "50acf06903644d550d4ebb3b")
			.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
	builder.header("Token", token);
	Boolean delete = builder.delete(Boolean.class);
	System.out.println(delete);
}

@Test
public void testDeleteRecord() {
	String path = "/relation/record/delete";

	Builder builder = RestClient.getResource().path(path).queryParam("id", "50acf18103644d550d4ebb3d")
			.queryParam("relation", "50acec690364e521c4b10c2d").type(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	builder.header("Token", token);
	Boolean delete = builder.delete(Boolean.class);
	System.out.println(delete);
}

@Test
public void testAddRecord() {
	String path = "/relation/record/create";
	Record record = new Record();
	Builder builder = RestClient.getResource().path(path).queryParam("relation", "50acec690364e521c4b10c2d")
			.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
	builder.header("Token", token);
	Record result = null;
	try {
		result = builder.post(Record.class, record);
	} catch (UniformInterfaceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClientHandlerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertNotNull(result);
}

@Test
public void testDeleteResource() {
	String path = "/relation/resource/delete";

	Builder builder = RestClient.getResource().path(path).queryParam("id", "50acf26e03644d550d4ebb3e")
			.queryParam("relation", "50acec690364e521c4b10c2d").type(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	builder.header("Token", token);
	Boolean delete = builder.delete(Boolean.class);
	System.out.println(delete);
}

@Test
public void testAddResource() {
	String path = "/relation/resource/create";
	Resource resource = new Resource();
	Builder builder = RestClient.getResource().path(path).queryParam("relation", "50acec690364e521c4b10c2d")
			.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
	builder.header("Token", token);
	Resource result = null;
	try {
		result = builder.post(Resource.class, resource);
	} catch (UniformInterfaceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClientHandlerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertNotNull(result);
}

}
