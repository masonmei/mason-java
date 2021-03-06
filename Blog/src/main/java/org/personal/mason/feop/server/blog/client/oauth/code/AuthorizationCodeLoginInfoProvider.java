package org.personal.mason.feop.server.blog.client.oauth.code;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.map.ObjectMapper;
import org.personal.mason.feop.server.blog.client.oauth.OAuthLoginInfoProvider;

public class AuthorizationCodeLoginInfoProvider extends OAuthLoginInfoProvider {

	@Override
	public String getAuthorizationRequestUrl(String callback) {

		StringBuilder urlPattern = new StringBuilder();
		List<String> params = new LinkedList<>();
		urlPattern.append("%s?");
		params.add(getConfiguration().getAuthUrl());
		urlPattern.append("client_id=%s");
		params.add(getConfiguration().getClientId());

		urlPattern.append("&response_type=code");

		if (callback != null) {
			try {
				params.add(URLEncoder.encode(callback, "UTF-8"));
				urlPattern.append("&redirect_uri=%s");
			} catch (UnsupportedEncodingException e) {
			}
		}

		if (getConfiguration().getScope() != null) {
			urlPattern.append("&scope=%s");
			params.add(getConfiguration().getScope());
		}

		// if(getConfiguration().isEnableCSRF()){
		// urlPattern.append("&state=%s");
		// //TODO:
		// }

		return String.format(urlPattern.toString(), params.toArray());
	}

	@Override
	public String getAccessTokenRequestUrl(String callback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processAccessToken(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("error") == null) {
			requestAccessToken(request, response);
		} else {
			// TODO:
		}
	}

	private void requestAccessToken(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("code") != null) {
			StringBuilder urlPattern = new StringBuilder();
			List<String> params = new LinkedList<>();
			urlPattern.append("%s?");
			params.add(getConfiguration().getTokenAccessUrl());
			urlPattern.append("client_id=%s");
			params.add(getConfiguration().getClientId());
			urlPattern.append("&client_secret=%s");
			params.add(getConfiguration().getClientSecret());

			urlPattern.append("&grant_type=authorization_code");

			String callback = request.getRequestURL().toString();
			if (callback != null) {
				try {
					params.add(URLEncoder.encode(callback, "UTF-8"));
					urlPattern.append("&redirect_uri=%s");
				} catch (UnsupportedEncodingException e) {
				}
			}

			if (getConfiguration().getScope() != null) {
				urlPattern.append("&scope=%s");
				params.add(getConfiguration().getScope());
			}

			String code = request.getParameter("code");
			urlPattern.append("&code=%s");
			params.add(code);

			// if(getConfiguration().isEnableCSRF()){
			// urlPattern.append("&state=%s");
			// //TODO:
			// }

			try {
				String uri = String.format(urlPattern.toString(), params.toArray());
				ObjectMapper mapper = new ObjectMapper();
				@SuppressWarnings("unchecked")
				Map<String, String> properties = mapper.readValue(new URL(uri), Map.class);
				HttpSession session = request.getSession(true);

				session.setAttribute(AUTHENTICATIOIN, new AuthorizationCodeAuthentication(properties));
				response.sendRedirect(request.getRequestURI());
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean isDirectlyRequestToken(HttpServletRequest request) {
		String referer = request.getHeader("referer");
		return referer != null && referer.contains(getConfiguration().getAuthUrl());
	}

}
