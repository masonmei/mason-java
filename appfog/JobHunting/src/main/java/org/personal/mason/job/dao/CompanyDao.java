package org.personal.mason.job.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.search.Query;
import org.hibernate.HibernateException;
import org.hibernate.search.SearchException;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.personal.mason.job.domain.Company;

public class CompanyDao extends DAO<Company> {

public CompanyDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected Class<Company> getClazz() {
	return Company.class;
}

@SuppressWarnings("unchecked")
public List<Company> searchByCompanyName(String name, int firstResult, int maxResults) {
	if (StringUtils.isEmpty(name)) {
		return new ArrayList<Company>();
	}
	try {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(getClazz()).get();
		Query query = queryBuilder.keyword().onFields("companyName", "description", "labels.labelName", "products.productName", "newses.title").matching(name).createQuery();
		FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, getClazz());
		return fullTextQuery.getResultList();
	} catch (SearchException e) {
		return new ArrayList<Company>();
	} catch (HibernateException e) {
		throw new RuntimeException(e);
	}
}

}
