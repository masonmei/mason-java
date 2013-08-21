package org.personal.mason.feop.server.blog.client.oauth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class OAuthLoginInfoProvider {

	private ClientConfiguration configuration;

	public void setConfiguration(ClientConfiguration configuration) {
		this.configuration = configuration;
	}

	public abstract String getAuthorizationRequestUrl(String callback);

	public abstract void processAccessToken(HttpServletRequest request, HttpServletResponse response);

	public abstract String getAccessTokenRequestUrl();

	public boolean isRefererFromOServer(HttpServletRequest request) {
		String referer = request.getHeader("referer");
		return referer != null && referer.contains(configuration.getAuthUrl());
	}

	public ClientConfiguration getConfiguration() {
		return configuration;
	}

	// ===================================================================//
	public boolean isLogin() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
