package org.personal.mason.job.service;

import java.util.List;

import javax.annotation.Resource;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.ProductDao;
import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService extends DefaultService<Product> {

@Resource
private ProductDao productDao;

public ProductDao getProductDao() {
	return productDao;
}

public void setProductDao(ProductDao productDao) {
	this.productDao = productDao;
}

@Override
public DAO<Product> getDao() {
	return productDao;
}

public List<Product> findCompanyProducts(Company company) {
	return findCompanyProducts(company, -1, -1);
}

@Transactional(readOnly = true)
public List<Product> findCompanyProducts(Company company, Integer start, Integer length) {
	return productDao.findCompanyProducts(company, start, length);
}

}
