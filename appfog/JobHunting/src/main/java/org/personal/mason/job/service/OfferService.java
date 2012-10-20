package org.personal.mason.job.service;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.OfferDao;
import org.personal.mason.job.domain.Offer;

public class OfferService extends DefaultService<Offer> {

private OfferDao offerDao;

public OfferDao getOfferDao() {
	return offerDao;
}

public void setOfferDao(OfferDao offerDao) {
	this.offerDao = offerDao;
}

@Override
public DAO<Offer> getDao() {
	return offerDao;
}

}
