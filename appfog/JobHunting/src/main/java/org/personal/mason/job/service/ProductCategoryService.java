package org.personal.mason.job.service;

import java.util.List;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.ProductCategoryDao;
import org.personal.mason.job.domain.ProductCategory;
import org.springframework.stereotype.Service;
@Service
public class ProductCategoryService extends DefaultService<ProductCategory> {

private ProductCategoryDao productCategoryDao;

public ProductCategoryDao getProductCategoryDao() {
	return productCategoryDao;
}

public void setProductCategoryDao(ProductCategoryDao productCategoryDao) {
	this.productCategoryDao = productCategoryDao;
}

@Override
public DAO<ProductCategory> getDao() {
	return productCategoryDao;
}

public List<ProductCategory> getProductCategoryRoots() {
	return productCategoryDao.getProductCategoryRoots();
}

public List<ProductCategory> getProduCategoryChildren(ProductCategory productCategory) {
	return productCategoryDao.getProduCategoryChildren(productCategory);
}

}
