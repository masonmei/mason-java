package org.personal.mason.feop.oauth.service.mvc.controllers;

import javax.validation.Valid;

import org.personal.mason.feop.oauth.service.domain.OauthClientDetail;
import org.personal.mason.feop.oauth.service.mvc.model.ClientForm;
import org.personal.mason.feop.oauth.service.spi.OClientDetailService;
import org.personal.mason.feop.oauth.service.spi.impl.ClientTypes;
import org.personal.mason.feop.oauth.service.utils.SecuriteGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ApplicationRegistrationController {

	private OClientDetailService clientDetailService;

	@Autowired
	public void setClientDetailService(OClientDetailService clientDetailService) {
		if (clientDetailService == null) {
			throw new IllegalArgumentException("client Details Service cannot be null");
		}
		this.clientDetailService = clientDetailService;
	}

	@RequestMapping(value = { "/client/", "/client/form" })
	public String signup(@ModelAttribute ClientForm clientForm, ModelMap map) {
		map.addAttribute("client_types", ClientTypes.getAllTypes());
		return "client/form";
	}

	@RequestMapping(value = "/client/create", method = RequestMethod.POST)
	public String signup(@Valid ClientForm clientForm, BindingResult result, RedirectAttributes redirectAttributes, ModelMap map) {
		if (result.hasErrors()) {
			return "redirect:/client/form";
		}

		String appName = clientForm.getClientName();
		if (clientDetailService.findByClientId(appName) != null) {
			result.rejectValue("clientName", "errors.client.clientName", "Application Name already in use.");
			return "redirect:/client/form";
		}

		OauthClientDetail client = new OauthClientDetail();
		client.setClientId(appName);
		client.setClientSecret(SecuriteGenerator.generateUniqueSecret());
		client.setWebServerRedirectUri(clientForm.getRedirectUrl());
		clientDetailService.decorateClientBy(client, clientForm.getClientType());

		clientDetailService.createApplication(client);
		map.addAttribute("client", client);
		return "client/info";
	}
}
