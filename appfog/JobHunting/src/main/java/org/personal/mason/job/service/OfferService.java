package org.personal.mason.job.service;

import org.personal.mason.job.dao.OfferDao;
import org.personal.mason.job.domain.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mmei
 * 
 */
@Service("offerService")
public class OfferService extends DefaultService<Offer> {

	@Autowired
	private OfferDao offerDao;

	public OfferDao getOfferDao() {
		return offerDao;
	}

	public void setOfferDao(OfferDao offerDao) {
		super.setDao(offerDao);
		this.offerDao = offerDao;
	}

}
