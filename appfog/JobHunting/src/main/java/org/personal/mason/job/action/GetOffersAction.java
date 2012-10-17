package org.personal.mason.job.action;

import java.util.List;

import org.personal.mason.job.domain.Offer;
import org.personal.mason.job.service.OfferService;

public class GetOffersAction extends AbstractAction {
private static final long serialVersionUID = 7500450981656793561L;

private List<Offer> offers;
private OfferService offerService;
private int page;
private int pageSize;

public void setOfferService(OfferService offerService) {
	this.offerService = offerService;
}

public void setPage(int page) {
	this.page = page;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public List<Offer> getOffers() {
	return this.offers;
}

@Override
public String process() {
	try {
		if (pageSize <= 0 || page < 0) {
			offers = offerService.findAll();
		} else {
			offers = offerService.findInScope(page * pageSize, pageSize);
		}
		return SUCCESS;
	} catch (Exception e) {
		log.debug("cannot get offers", e);
	}
	return null;
}

}
