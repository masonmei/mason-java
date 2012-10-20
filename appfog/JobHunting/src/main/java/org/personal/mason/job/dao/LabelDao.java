package org.personal.mason.job.dao;

import javax.persistence.EntityManager;

import org.personal.mason.job.domain.Label;

public class LabelDao extends DAO<Label> {

public LabelDao() {
}

public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

public void setClazz(Class<Label> clazz) {
	this.clazz = clazz;
}
}
