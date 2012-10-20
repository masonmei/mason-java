package org.personal.mason.job.dao;

import javax.persistence.EntityManager;

import org.personal.mason.job.domain.Interview;

public class InterviewDao extends DAO<Interview> {

public InterviewDao() {
}

public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

public void setClazz(Class<Interview> clazz) {
	this.clazz = clazz;
}
}
