package org.personal.mason.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.personal.mason.domain.Offer;
import org.personal.mason.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/offer")
public class OfferController {

@Autowired
private OfferService offerService;

public void setOfferService(OfferService offerService) {
	this.offerService = offerService;
}

@InitBinder
public void InitBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	dateFormat.setLenient(false);
	binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
}

@RequestMapping(value = "/list", method = RequestMethod.GET)
public String listOffer(Integer startIndex, Integer pageSize, Map<String, Object> map) {
	if (startIndex == null || startIndex < 0) {
		startIndex = 0;
	}

	if (pageSize == null || pageSize <= 0) {
		pageSize = 10;
	}

	Page<Offer> offers = offerService.findInScope(startIndex, pageSize);
	long count = offerService.count();
	map.put("offers", offers.iterator());
	map.put("count", count);
	return "offers";
}

@RequestMapping(value = "/add", method = RequestMethod.GET)
public String addOffer(Map<String, Object> map) {
	map.put("offer", new Offer());
	return "offer_edit";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveOffer(Offer offer) {
	offerService.save(offer);
	return "redirect:list";
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewOffer(@RequestParam("id") String id, Map<String, Object> map) {
	Offer offer = offerService.findById(id);
	map.put("offer", offer);
	return "offer";
}

@RequestMapping(value = "/delete")
public String deleteOffer(@RequestParam("id") String id) {
	offerService.delete(id);
	return "redirect:list";
}

}
