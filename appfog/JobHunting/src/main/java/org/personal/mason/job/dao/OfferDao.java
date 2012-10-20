package org.personal.mason.job.dao;

import javax.persistence.EntityManager;

import org.personal.mason.job.domain.Offer;

public class OfferDao extends DAO<Offer> {

public OfferDao() {
}

public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

public void setClazz(Class<Offer> clazz) {
	this.clazz = clazz;
}
}
