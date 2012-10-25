package org.personal.mason.job.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.job.domain.Interview;

public class InterviewDao extends DAO<Interview> {

public InterviewDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected Class<Interview> getClazz() {
	return Interview.class;
}
}
