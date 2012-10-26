package org.personal.mason.job.controller;

import java.util.List;
import java.util.Map;

import org.personal.mason.job.domain.Offer;
import org.personal.mason.job.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCompany(Integer startIndex, Integer pageSize, Map<String, Object> map) {
		if (startIndex == null || startIndex < 0) {
			startIndex = 0;
		}

		if (pageSize == null || pageSize <= 0) {
			pageSize = 10;
		}

		List<Offer> offers = offerService.findInScope(startIndex, pageSize);
		long count = offerService.countAll();
		map.put("offers", offers);
		map.put("count", count);
		return "offers";
	}
		
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addOffer(Offer offer) {
		offerService.save(offer);
		return null;
	}

	@RequestMapping(value = "/delete")
	public String deleteInterviewMaterial(@RequestParam("id") Long id) {
		offerService.deleteById(id);
		return null;
	}
	
}
