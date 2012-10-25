package org.personal.mason.job.service;

import javax.annotation.Resource;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.ProductDao;
import org.personal.mason.job.domain.Product;
import org.springframework.stereotype.Service;
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


}
