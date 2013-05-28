package org.personal.mason.spring.oauth2.mvc;

import java.security.Principal;

import org.personal.mason.spring.oauth2.PhotoServiceUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Michael Lavelle
 * 
 * Added to provide an endpoint from which Spring Social can obtain authentication details
 */
@RequestMapping("/me")
@Controller
public class PhotoServiceUserController {

	private UserDetailsService userDetailsService;

	
	@ResponseBody
	@RequestMapping("")
	public PhotoServiceUser getPhotoServiceUser(Principal principal)
	{
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		return new PhotoServiceUser(userDetails.getUsername(),userDetails.getUsername());
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
}
