package org.personal.mason.feop.server.blog.client.oauth.code;

import java.util.Calendar;
import java.util.Map;

import org.personal.mason.feop.server.blog.client.oauth.FEOPAuthentication;

public class AuthorizationCodeAuthentication implements FEOPAuthentication {
	private static final String ACCESS_TOKEN = "access_token";
	private static final String TOKEN_TYPE = "token_type";
	private static final String EXPIRES_IN = "expires_in";
	private static final String REFRESH_TOKEN = "refresh_token";
	private static final String SCOPE = "scope";
	private static final String STATE = "state";

	private long createTime;
	private String accessToken;
	private String tokenType;
	private int expiresIn;
	private String refreshToken;
	private String scope;

	public AuthorizationCodeAuthentication(Map<String, String> properties) {
		createTime = Calendar.getInstance().getTimeInMillis() / 1000;
		accessToken = properties.get(ACCESS_TOKEN);
		tokenType = properties.get(TOKEN_TYPE);
		String expiresInString = properties.get(EXPIRES_IN);
		expiresIn = Integer.valueOf(expiresInString == null ? "0" : expiresInString);
		refreshToken = properties.get(REFRESH_TOKEN);
		scope = properties.get(SCOPE);
	}

	@Override
	public boolean hasValidToken() {
		return accessToken != null;
	}

	@Override
	public boolean hasRole(String role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTokenExpired() {
		return accessToken != null && (Calendar.getInstance().getTimeInMillis() / 1000) > createTime + expiresIn;
	}

	@Override
	public String getRefreshToken() {
		return refreshToken;
	}

	@Override
	public String getTokenType() {
		return tokenType;
	}

	@Override
	public String getScope() {
		return scope;
	}
}
