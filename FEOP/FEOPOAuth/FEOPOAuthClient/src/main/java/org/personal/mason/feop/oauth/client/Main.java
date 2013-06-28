package org.personal.mason.feop.oauth.client;

import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class Main {
	private static final String PROTECTED_RESOURCE_URL = "http://www.baidu.com/";
	
//	private static final String SECRET_KEY = "5546407edc3af59f";
//	private static final String API_KEY = "authcode";
	private static final String SECRET_KEY = "Stxaivj1986";
	private static final String API_KEY = "mason.mei@gmail.com";
	private static final Token EMPTY_TOKEN = null;

	private static final String CALLBACK = "http://www.baidu.com/";
	
	public static void main(String[] args) {
		OAuthService service = new ServiceBuilder().provider(OAuth2ServiceApi.class).apiKey(API_KEY).apiSecret(SECRET_KEY).callback(CALLBACK).build();
		Scanner in = new Scanner(System.in);

	    System.out.println("=== Oauth2's OAuth Workflow ===");
	    System.out.println();

	    // Obtain the Request Token
	    System.out.println("Fetching the Request Token...");
	    String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
	    System.out.println("Got the Authorization URL!");
	    System.out.println("Now go and authorize Scribe here:");

	    System.out.println(authorizationUrl);
	    System.out.println("And paste the authorization code here");
	    System.out.print(">>");
	    Verifier verifier = new Verifier(in.nextLine());
	    System.out.println();

	    // Trade the Request Token and Verifier for the Access Token
	    System.out.println("Trading the Request Token for an Access Token...");
	    Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
	    System.out.println("Got the Access Token!");
	    System.out.println("(if your curious it looks like this: " + accessToken + " )");
	    System.out.println();

	    // Now let's go and ask for a protected resource!
	    System.out.println("Now we're going to access a protected resource...");
	    OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
	    service.signRequest(accessToken, request);
	    Response response = request.send();
	    System.out.println("Got it! Lets see what we found...");
	    System.out.println();
	    System.out.println(response.getCode());
	    System.out.println(response.getBody());

	    System.out.println();
	    System.out.println("Thats it man! Go and build something awesome with Scribe! :)");	}
}
