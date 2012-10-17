package org.personal.mason.job.action;

import java.util.List;

import org.personal.mason.job.domain.ProductCategory;
import org.personal.mason.job.service.ProductCategoryService;

public class GetProductCategoryChildrenAction extends AbstractAction {

private static final long serialVersionUID = -7750435252129843512L;
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
		String parameter = request.getParameter("id");
		if (parameter != null) {
			ProductCategory pc = productCategoryService.findById(Long.parseLong(parameter));
			if (pc != null) {
				productCategories = productCategoryService.getProduCategoryChildren(pc);
				return SUCCESS;
			}
		}
	} catch (NumberFormatException e) {
		log.debug("delete failed", e);
	}
	return null;
}

}
