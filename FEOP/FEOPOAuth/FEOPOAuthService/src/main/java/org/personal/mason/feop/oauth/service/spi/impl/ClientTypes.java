package org.personal.mason.feop.oauth.service.spi.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.acls.model.NotFoundException;

public enum ClientTypes {

	WebApp("authorization_code,client_credentials,implicit,refresh_token,password", "ROLE_CLIENT,ROLE_TRUSTED_CLIENT", "read,write,trust", 60, 0), Mobile(
			"authorization_code,client_credentials,implicit,refresh_token,password", "ROLE_CLIENT,ROLE_TRUSTED_CLIENT", "read,write,trust", 120, 0);

	private String grantTypes;
	private String authorities;
	private String scope;
	private int accessTokenValidity;
	private int refreshTokenValidity;

	private ClientTypes(String grantTypes, String authorities, String scope, int accessTokenValidity, int refreshTokenValidity) {
		this.grantTypes = grantTypes;
		this.authorities = authorities;
		this.scope = scope;
		this.accessTokenValidity = accessTokenValidity;
		this.refreshTokenValidity = refreshTokenValidity;
	}

	public int getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public String getAuthorities() {
		return authorities;
	}

	public String getGrantTypes() {
		return grantTypes;
	}

	public int getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public String getScope() {
		return scope;
	}

	public static List<String> getAllTypes() {
		return Arrays.asList(WebApp.name(), Mobile.name());
	}

	public static ClientTypes getClientTypeWithName(String name) {
		for (ClientTypes type : ClientTypes.values()) {
			if (type.name().endsWith(name)) {
				return type;
			}
		}

		throw new NotFoundException(String.format("Cannot found a type with name %s", name));
	}
}
