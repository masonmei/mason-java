package org.personal.mason.job.service;

import org.personal.mason.job.dao.ProductDao;
import org.personal.mason.job.domain.Product;

public class ProductService extends DefaultService<Product> {

private ProductDao productDao;

public ProductDao getProductDao() {
	return productDao;
}

public void setProductDao(ProductDao productDao) {
	super.setDao(productDao);
	this.productDao = productDao;
}

}
