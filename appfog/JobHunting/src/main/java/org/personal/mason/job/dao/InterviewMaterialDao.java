package org.personal.mason.job.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.job.domain.InterviewMaterial;

public class InterviewMaterialDao extends DAO<InterviewMaterial> {

public InterviewMaterialDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected Class<InterviewMaterial> getClazz() {
	return InterviewMaterial.class;
}
}
