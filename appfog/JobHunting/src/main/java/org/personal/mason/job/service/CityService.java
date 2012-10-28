package org.personal.mason.job.service;

import java.util.List;

import javax.annotation.Resource;

import org.personal.mason.job.dao.CityDao;
import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.domain.City;
import org.personal.mason.job.domain.Province;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityService extends DefaultService<City> {

@Resource
private CityDao cityDao;

public CityDao getCityDao() {
	return cityDao;
}

public void setCityDao(CityDao cityDao) {
	this.cityDao = cityDao;
}

@Override
public DAO<City> getDao() {
	return cityDao;
}

@Transactional(readOnly = true)
public List<City> getByProvince(Province province) {
	return cityDao.findByProvince(province);
}
}
