package org.personal.mason.feop.oauth.common.data;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class FEOPJpaRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable> extends
		JpaRepositoryFactoryBean<R, T, I> {
	
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		setMappingContext(new JpaMetamodelMappingContext(entityManager.getMetamodel()));
	}
	
	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new FEOPJpaRepositoryFactory<T, I>(entityManager);
	}

	private static class FEOPJpaRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {
		private EntityManager entityManager;

		public FEOPJpaRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
			this.entityManager = entityManager;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected Object getTargetRepository(RepositoryMetadata metadata) {
			return new FEOPJpaRepositoryImpl<T, I>((Class<T>) metadata.getDomainType(), entityManager);
		}

		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return FEOPJpaRepository.class;
		}
	}

}
