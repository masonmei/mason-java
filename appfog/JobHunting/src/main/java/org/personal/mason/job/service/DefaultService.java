package org.personal.mason.job.service;

import java.io.Serializable;
import java.util.Collection;

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
	public Collection<T> findAll() {
		return dao.findAll();
	}

	@Override
	public Collection<T> findInScope(int start, int length) {
		return dao.findInScope(start, length);
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
	public void save(T entity) {
		dao.save(entity);
	}

}
