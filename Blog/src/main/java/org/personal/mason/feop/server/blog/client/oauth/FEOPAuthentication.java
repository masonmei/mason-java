package org.personal.mason.feop.server.blog.client.oauth;

public interface FEOPAuthentication {

	boolean hasValidToken();

	boolean hasRole(String role);

	public boolean isTokenExpired();

	public String getRefreshToken();

	public String getTokenType();

	public String getScope();
}
