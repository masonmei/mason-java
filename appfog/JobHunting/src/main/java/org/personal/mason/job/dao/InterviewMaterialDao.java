package org.personal.mason.job.dao;

import javax.persistence.EntityManager;

import org.personal.mason.job.domain.InterviewMaterial;

public class InterviewMaterialDao extends DAO<InterviewMaterial> {

public InterviewMaterialDao() {
}

public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

public void setClazz(Class<InterviewMaterial> clazz) {
	this.clazz = clazz;
}
}
