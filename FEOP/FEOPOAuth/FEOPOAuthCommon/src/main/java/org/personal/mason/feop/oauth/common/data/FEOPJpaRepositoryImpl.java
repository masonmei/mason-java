package org.personal.mason.feop.oauth.common.data;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class FEOPJpaRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements
		FEOPJpaRepository<T, ID> {

	// private EntityManager entityManager;

	public FEOPJpaRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		// this.entityManager = entityManager;
	}

}
