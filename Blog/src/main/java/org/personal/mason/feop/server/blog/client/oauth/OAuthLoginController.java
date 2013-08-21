package org.personal.mason.feop.server.blog.client.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OAuthLoginController {

	private OAuthLoginInfoProvider loginInfoProvider;

	// @RequestMapping(value = { "/signin" }, method = RequestMethod.GET)
	public String signin(@RequestParam("type") String type) {
		String authRedirectUri = loginInfoProvider.getAuthorizationRequestUrl(null);
		if (authRedirectUri != null) {
			System.out.println("");
			return String.format("redirect:%s", authRedirectUri);
		}
		return null;
	}

}
