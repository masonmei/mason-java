package org.personal.mason.job.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.job.domain.Offer;

public class OfferDao extends DAO<Offer> {

private EntityManager entityManager;

public OfferDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected EntityManager getEntityManager() {
	return entityManager;
}

@Override
protected Class<Offer> getClazz() {
	return Offer.class;
}
}
