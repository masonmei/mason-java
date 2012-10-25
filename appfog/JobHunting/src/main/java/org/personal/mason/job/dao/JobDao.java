package org.personal.mason.job.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.job.domain.Job;

public class JobDao extends DAO<Job> {

private EntityManager entityManager;
public JobDao() {
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
protected Class<Job> getClazz() {
	return Job.class;
}
}
