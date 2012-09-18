package org.personal.mason.restful.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface IDAO<T> {
void save(T obj);

T update(T obj);

T saveOrUpdate(T entity);

void del(T obj);

T get(Class<T> clz, Serializable id);

List<T> getBy(Class<T> clz, String fieldName, Serializable value);

List<T> query(Class<T> clz, String scope);

List<T> query(Class<T> clz, String scope, Collection<?> params);

List<T> query(Class<T> clz, String scope, Collection<?> params, int begin, int max);

List<T> query(String query);

List<T> query(String query, Collection<?> params);

List<T> query(String query, Collection<?> params, int begin, int max);

Object uniqueResult(String sql);

Object uniqueResult(String sql, Collection<?> params);

int execute(String sql);

int execute(String sql, Collection<?> params);
}
