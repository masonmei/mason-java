package org.personal.mason.job.action;

import org.personal.mason.job.service.OfferService;

public class DeleteOfferAction extends AbstractAction {

private static final long serialVersionUID = 1767255071829090081L;

private OfferService offerService;
private String msg;
private boolean success;

public void setOfferService(OfferService offerService) {
	this.offerService = offerService;
}

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

@Override
public String process() {
	try {
		String parameter = request.getParameter("id");
		if (parameter != null) {
			offerService.deleteById(Long.parseLong(parameter));
			msg = "delete success";
			success = true;
			return SUCCESS;
		}
		msg = "nothing to delete";
		success = true;
	} catch (NumberFormatException e) {
		log.debug("delete failed", e);
	}
	return null;
}

}
