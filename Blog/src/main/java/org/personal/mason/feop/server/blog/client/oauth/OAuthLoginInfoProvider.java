package org.personal.mason.feop.server.blog.client.oauth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class OAuthLoginInfoProvider {
	protected static final String AUTHENTICATIOIN = "authentication";

	private ClientConfiguration configuration;

	public void setConfiguration(ClientConfiguration configuration) {
		this.configuration = configuration;
	}

	public abstract String getAuthorizationRequestUrl(String callback);

	public abstract void processAccessToken(HttpServletRequest request, HttpServletResponse response);

	public abstract String getAccessTokenRequestUrl(String callback);

	public abstract boolean isDirectlyRequestToken(HttpServletRequest request);

	public ClientConfiguration getConfiguration() {
		return configuration;
	}

	// ===================================================================//
	public boolean isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session == null) {
			return false;
		}
		FEOPAuthentication authentication = (FEOPAuthentication) session.getAttribute(AUTHENTICATIOIN);
		if (authentication != null && authentication.hasValidToken()) {
			return true;
		}
		return false;
	}

}
