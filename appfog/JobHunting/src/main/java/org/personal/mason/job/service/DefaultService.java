package org.personal.mason.job.service;

import java.io.Serializable;
import java.util.List;

import org.personal.mason.job.dao.IDAO;
import org.springframework.transaction.annotation.Transactional;

public class DefaultService<T> implements IService<T> {
	
	private IDAO<T> dao;
	
	protected void setDao(IDAO<T> dao){
		this.dao = dao;
	}
	
	@Override
	public T findById(Serializable id) {
		return dao.findById(id);
	}

	@Override
	public List<T> findAll() {
		return dao.findAll();
	}

	@Override
	public List<T> findInScope(int start, int length) {
		return dao.findInScope(start, length);
	}

	public List<T> findByExample(final T instance){
		return dao.findByExample(instance);
	}
	
	@Override
	@Transactional
	public void update(T entity) {
		dao.udpate(entity);
	}

	@Override
	@Transactional
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	@Transactional
	public void deleteById(Serializable id) {
		dao.deleteById(id);
	}
	
	@Override
	@Transactional
	public void save(T entity) {
		dao.save(entity);
	}

}
