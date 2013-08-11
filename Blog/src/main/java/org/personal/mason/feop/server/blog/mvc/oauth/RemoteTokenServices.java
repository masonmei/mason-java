package org.personal.mason.feop.server.blog.mvc.oauth;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.BaseClientDetails;
import org.springframework.security.oauth2.provider.DefaultAuthorizationRequest;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

public class RemoteTokenServices implements ResourceServerTokenServices {

	private RestOperations restTemplate;
	private String checkTokenEndpointUrl;

	private String clientId;

	private String clientSecret;

	public void setRestTemplate(RestOperations restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void setCheckTokenEndpointUrl(String checkTokenEndpointUrl) {
		this.checkTokenEndpointUrl = checkTokenEndpointUrl;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	@Override
	public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException {
//		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
//		formData.add("token", accessToken);
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Authorization", getAuthorizationHeader(clientId, clientSecret));
//		AppToken token = postForMap(checkTokenEndpointUrl, formData, headers);
//		Assert.state(token.getClientId() == null, "Client id must be present in response from auth server");
//		DefaultAuthorizationRequest clientAuthentication = new DefaultAuthorizationRequest(token.getClientId(), token.getScope());
//
//		if (token.getClientRoles() != null && token.getClientRoles().size() > 0) {
//			BaseClientDetails clientDetails = new BaseClientDetails();
//			clientDetails.setClientId(token.getClientId());
//			clientDetails.setAuthorities(getAuthorities(token.getClientRoles()));
//			clientAuthentication.addClientDetails(clientDetails);
//		}
//
//		Set<GrantedAuthority> userAuthorities = new HashSet<GrantedAuthority>();
//		if (token.getUserRoles() != null && token.getUserRoles().size() > 0) {
//			userAuthorities.addAll(getAuthorities(token.getUserRoles()));
//		} else {
//			userAuthorities.addAll(getAuthorities(token.getScope()));
//		}
//		Authentication userAuthentication = new UsernamePasswordAuthenticationToken(token.getUsername(), null, userAuthorities);
//
//		clientAuthentication.setApproved(true);
//		return new OAuth2Authentication(clientAuthentication, userAuthentication);
		return null;
	}

	@Override
	public OAuth2AccessToken readAccessToken(String accessToken) {
		throw new UnsupportedOperationException("Not supported: read access token");
	}

//	private Set<GrantedAuthority> getAuthorities(Collection<String> authorities) {
//		Set<GrantedAuthority> result = new HashSet<GrantedAuthority>();
//		for (String authority : authorities) {
//			result.add(new SimpleGrantedAuthority(authority));
//		}
//		return result;
//	}
//
//	private String getAuthorizationHeader(String clientId, String clientSecret) {
//		String creds = String.format("%s:%s", clientId, clientSecret);
//		try {
//			return "Basic " + new String(Base64.encode(creds.getBytes("UTF-8")));
//		} catch (UnsupportedEncodingException e) {
//			throw new IllegalStateException("Could not convert String");
//		}
//	}
//
//	private AppToken private Set<GrantedAuthority> getAuthorities(Collection<String> authorities) {
//		Set<GrantedAuthority> result = new HashSet<GrantedAuthority>();
//		for (String authority : authorities) {
//		result.add(new SimpleGrantedAuthority(authority));
//		}
//		return result;
//		}
//		 
//		private String getAuthorizationHeader(String clientId, String clientSecret) {
//		String creds = String.format(“%s:%s”, clientId, clientSecret);
//		try {
//		return “Basic ” + new String(Base64.encode(creds.getBytes(“UTF-8″)));
//		}
//		catch (UnsupportedEncodingException e) {
//		throw new IllegalStateException(“Could not convert String”);
//		}
//		}
//		 
//		private AppToken postForMap(String path, MultiValueMap<String, String> formData, HttpHeaders headers) {
//		if (headers.getContentType() == null) {
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//		}
//		AppToken result = restTemplate.exchange(path, HttpMethod.POST,
//		new HttpEntity<MultiValueMap<String, String>>(formData, headers), AppToken.class).getBody();
//		return result;
//		}(String path, MultiValueMap<String, String> formData, HttpHeaders headers) {
//		if (headers.getContentType() == null) {
//			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//		}
//		AppToken result = restTemplate.exchange(path, HttpMethod.POST, new HttpEntity<MultiValueMap<String, String>>(formData, headers),
//				AppToken.class).getBody();
//		return result;
//	}

}
