package org.personal.mason.job.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.job.domain.Province;

public class ProvinceDao extends DAO<Province> {

public ProvinceDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected Class<Province> getClazz() {
	return Province.class;
}

}
