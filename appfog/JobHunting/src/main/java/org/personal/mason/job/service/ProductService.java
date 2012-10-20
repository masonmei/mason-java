package org.personal.mason.job.service;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.ProductDao;
import org.personal.mason.job.domain.Product;

public class ProductService extends DefaultService<Product> {

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
