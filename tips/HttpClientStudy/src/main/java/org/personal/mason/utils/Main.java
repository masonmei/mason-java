package org.personal.mason.utils;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.personal.mason.domain.Account;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	String serviceRoot = "http://pbserver.aws.af.cm/rest/";
	JsonClient jsonClient = new JsonClient(serviceRoot);

	HttpPost post = new HttpPost(serviceRoot + "account/validate");
	Account account = new Account();
	account.setEmail("mason.mei@gmai.com");
	account.setAccount("mason.mei@gmail.com");
	account.setSecret("rdisfun");
	account.setCreatedate(Calendar.getInstance().getTime());

	StringEntity buildEntity = jsonClient.buildEntity(account);
	post.setEntity(buildEntity);
	String executeRequest = jsonClient.executeRequest(post);

	System.out.println(executeRequest);
	
	GsonBuilder gsonBuilder = new GsonBuilder();
	gsonBuilder.registerTypeAdapter(Date.class, new DateJsonTypeAdapter());
	
	Gson gson = gsonBuilder.create();
	Account element = gson.fromJson(executeRequest, Account.class);
	System.out.println(element);
	
}
}
