package org.personal.mason.job.action;

import java.util.List;

import org.personal.mason.job.domain.ProductCategory;
import org.personal.mason.job.service.ProductCategoryService;

public class GetProductCategoryRootsAction extends AbstractAction {

private static final long serialVersionUID = 5269879017355323114L;
private List<ProductCategory> productCategories;
private ProductCategoryService productCategoryService;

public List<ProductCategory> getProductCategories() {
	return productCategories;
}

public void setProductCategoryService(ProductCategoryService productCategoryService) {
	this.productCategoryService = productCategoryService;
}

@Override
public String process() {
	try {
		productCategories = productCategoryService.getProductCategoryRoots();
		return SUCCESS;
	} catch (Exception e) {
		log.debug("failed to get productCategoryRoots", e);
	}
	return null;
}

}
