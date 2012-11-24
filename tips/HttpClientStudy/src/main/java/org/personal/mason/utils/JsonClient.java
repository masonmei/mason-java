package org.personal.mason.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.personal.mason.domain.Account;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonClient {
private DefaultHttpClient httpClient;

private final String serverRoot;

public JsonClient(ClientConnectionManager conman, HttpParams params, String serverRoot) {
	httpClient = new DefaultHttpClient(conman, params);
	this.serverRoot = serverRoot;
}

public JsonClient(HttpParams params, String serverRoot) {
	this(null, params, serverRoot);
}

public JsonClient(String serverRoot) {
	this(null, serverRoot);
}

private String executeRequest(HttpUriRequest request) {
	try {
		HttpResponse response = httpClient.execute(request);
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			HttpEntity entity = response.getEntity();
			String value = entity.getContentType().getValue();
			System.out.println(value);
			String contentString = readStream(entity.getContent());
			return contentString;
		}
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

private String readStream(InputStream stream){
	if(stream == null){
		return "";
	}
	StringBuilder builder = new StringBuilder();
	try {
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		String line;
		while ((line = br.readLine()) != null) {
			builder.append(line);
		}
		return builder.toString();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "";
}

public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	String serviceRoot = "http://pbserver.aws.af.cm/rest/";
	JsonClient jsonClient = new JsonClient(serviceRoot);
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	ObjectMapper mapper = new ObjectMapper();
	

	String path = "account/validate";
	Account account = new Account();
	account.setEmail("mason.mei@gmai.com");
	account.setAccount("mason.mei@gmail.com");
	account.setSecret("rdisfun");
	String jsonString1 = gson.toJson(account);
	String jsonString = mapper.writeValueAsString(account);
	
	HttpPost post = new HttpPost(serviceRoot + path);
	post.addHeader("Content-Type", "application/json");
	post.addHeader("Accept", "application/json");

	StringEntity entity = new StringEntity(jsonString1, HTTP.UTF_8);
	entity.setContentType("application/json");
	post.setEntity(entity);

	String executeRequest = jsonClient.executeRequest(post);
	
	System.out.println(executeRequest);
}

}
