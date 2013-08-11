package org.personal.mason.feop.server.blog.mvc.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.personal.mason.feop.server.blog.mvc.oauth.FEOPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	private FEOPService feopService;

	@Autowired
	public void setFeopService(FEOPService feopService) {
		this.feopService = feopService;
	}

	@RequestMapping(value = { "/signin" }, method = RequestMethod.GET)
	public String signin(@RequestParam("type") String type) {
		String authRedirectUri = getAuthenticationUrl(type);
		if (authRedirectUri != null) {
			System.out.println("");
			return String.format("redirect:%s", authRedirectUri);
		}
		return null;
	}

	@RequestMapping(value = { "/signin/oauth" })
	public String oauthUserAuthorized(@RequestParam("code") String code) {
		String tokenAccessUri = buildAccessTokenUrl(code);
		if (tokenAccessUri != null) {
			System.out.println(tokenAccessUri);

			return String.format("redirect:", tokenAccessUri);
		}
		return null;
	}

	private String buildAccessTokenUrl(String code) {
		try {
			String grantType = "authorization_code";
			String orignalRedirectUrl = "http://localhost:8888/blog/";// TODO
			String redirectUri = URLEncoder.encode(orignalRedirectUrl, "UTF-8");
			String tokenAccessUrl = "http://localhost:8889/oauth2/oauth/token";
			return String.format("%s?grant_type=%s&code=%s&redirect_uri=%s", tokenAccessUrl, grantType, code, redirectUri);
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	private String getAuthenticationUrl(String type) {
		if (type.equals("feop")) {
			try {
				String clientId = "mason4mei";
				String orignalRedirectUrl = "http://localhost:8888/signin/oauth";// TODO
				String redirectUrl = URLEncoder.encode(orignalRedirectUrl, "UTF-8");
				String responseType = "code";
				String authenticationServerUrl = "http://localhost:8889/oauth2/oauth/authorize";
				return String
						.format("%s?client_id=%s&redirect_uri=%s&response_type=%s", authenticationServerUrl, clientId, redirectUrl, responseType);
			} catch (UnsupportedEncodingException e) {
			}
		}
		return null;
	}
}
