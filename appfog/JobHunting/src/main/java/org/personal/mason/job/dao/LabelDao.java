package org.personal.mason.job.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.job.domain.Label;

public class LabelDao extends DAO<Label> {

private EntityManager entityManager;
public LabelDao() {
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
protected Class<Label> getClazz() {
	return Label.class;
}
}
