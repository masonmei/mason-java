package org.personal.mason.job.service;

import org.personal.mason.job.dao.ProductDao;
import org.personal.mason.job.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService extends DefaultService<Product> {

	@Autowired
	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		super.setDao(productDao);
		this.productDao = productDao;
	}

}
