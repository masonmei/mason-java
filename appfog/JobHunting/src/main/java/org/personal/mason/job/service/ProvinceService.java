package org.personal.mason.job.service;

import javax.annotation.Resource;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.ProvinceDao;
import org.personal.mason.job.domain.Province;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProvinceService extends DefaultService<Province> {

@Resource
private ProvinceDao provinceDao;

public ProvinceDao getProvinceDao() {
	return provinceDao;
}

public void setProvinceDao(ProvinceDao provinceDao) {
	this.provinceDao = provinceDao;
}

@Override
public DAO<Province> getDao() {
	return provinceDao;
}

@Transactional(readOnly = true)
public Province findByProvinceName(String province) {
	return provinceDao.findByProvinceName(province);
}

}
