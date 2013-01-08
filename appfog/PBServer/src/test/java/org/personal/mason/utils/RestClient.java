package org.personal.mason.utils;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public enum RestClient {
RestClient;

private static final String RESOURCE_URI = "http://pbserver.aws.af.cm/rest";
private Client client;
private ObjectMapper mapper;
private WebResource resource;

private RestClient(){
	ClientConfig config = new DefaultClientConfig();
	config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
	client = Client.create(config);
	resource = client.resource(RESOURCE_URI);
}

public static Client getClient() {
	return RestClient.client;
}

public static ObjectMapper getMapper() {
	return RestClient.mapper;
}

public static WebResource getResource() {
	return RestClient.resource;
}
}
