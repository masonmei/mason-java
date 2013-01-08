package org.personal.mason.competition.thirdparty;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.multipart.FormDataMultiPart;

public class MailGun {

private String apiKey;
private String apiURL;
private String account;

public void setApiKey(String apiKey) {
	this.apiKey = apiKey;
}

public void setApiURL(String apiURL) {
	this.apiURL = apiURL;
}

public void setAccount(String account) {
	this.account = account;
}

public MailGun() {
}

public MailGun(String apiKey, String apiURL, String account) {
	this.apiKey = apiKey;
	this.apiURL = apiURL;
	this.account = account;
}

private Client createClient() {
	Client client = Client.create();
	client.addFilter(new HTTPBasicAuthFilter("api", apiKey));
	return client;
}

public ClientResponse sendMimeMessage(String htmlContent, String subject, String... receivers) {
	WebResource resource = createClient().resource(apiURL);
	FormDataMultiPart form = new FormDataMultiPart();
	form.field("from", account);

	if (receivers != null) {
		for (String receiver : receivers) {
			form.field("to", receiver);
		}
	}

	form.field("subject", subject);
	form.field("html", htmlContent);
	return resource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class, form);
}

}
