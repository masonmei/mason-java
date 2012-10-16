package org.personal.mason.job.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IDAO<T> {

T findById(Serializable id);

List<T> findAll();

List<T> findInScope(int start, int length);

List<T> findByExample(final T exampleInstance);

List<T> findByNamedQuery(final String name, Object... params);

List<T> findByNamedQueryAndNamedParams(final String name, final Map<String, ? extends Object> params);

long countAll();

long countByExample(final String exampleInstance);

void save(final T entity);

void udpate(final T entity);

void delete(final T entity);

void deleteById(final Serializable id);

}
