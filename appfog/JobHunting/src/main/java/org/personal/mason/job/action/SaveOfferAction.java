package org.personal.mason.job.action;

import org.personal.mason.job.domain.Offer;
import org.personal.mason.job.service.OfferService;

import com.opensymphony.xwork2.ModelDriven;

public class SaveOfferAction extends AbstractAction implements ModelDriven<Offer> {

private static final long serialVersionUID = 1492852228010036578L;

private Offer offer = new Offer();
private OfferService offerService;
private String msg;
private boolean success;

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

public void setOfferService(OfferService offerService) {
	this.offerService = offerService;
}

@Override
public String process() {
	try {
		offerService.save(offer);
		msg = "Save Offer Success";
		success = true;
	} catch (Exception e) {
		log.debug("save offer failed", e);
	}
	return "result";
}

@Override
public Offer getModel() {
	return offer;
}

}
