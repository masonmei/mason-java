package org.personal.mason.job.dao;

import javax.persistence.EntityManager;

import org.personal.mason.job.domain.Job;

public class JobDao extends DAO<Job> {

public JobDao() {
}

public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

public void setClazz(Class<Job> clazz) {
	this.clazz = clazz;
}
}
