package org.personal.mason.job.service;

import java.util.List;

import org.personal.mason.job.dao.ProductCategoryDao;
import org.personal.mason.job.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productCategoryService")
public class ProductCategoryService extends DefaultService<ProductCategory> {

	@Autowired
	private ProductCategoryDao productCategoryDao;

	public ProductCategoryDao getProductCategoryDao() {
		return productCategoryDao;
	}

	public void setProductCategoryDao(ProductCategoryDao productCategoryDao) {
		super.setDao(productCategoryDao);
		this.productCategoryDao = productCategoryDao;
	}
	
	public List<ProductCategory> getProductCategoryRoots(){
		return productCategoryDao.getProductCategoryRoots();
	}
	
	public List<ProductCategory> getProduCategoryChildren(ProductCategory productCategory){
		return productCategoryDao.getProduCategoryChildren(productCategory);
	}

}
