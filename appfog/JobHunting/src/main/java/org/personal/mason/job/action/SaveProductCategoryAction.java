package org.personal.mason.job.action;

import org.personal.mason.job.domain.ProductCategory;
import org.personal.mason.job.service.ProductCategoryService;

import com.opensymphony.xwork2.ModelDriven;

public class SaveProductCategoryAction extends AbstractAction implements ModelDriven<ProductCategory> {

private static final long serialVersionUID = 7879015480512551692L;

private ProductCategory productCategory = new ProductCategory();
private ProductCategoryService productCategoryService;
private String msg;
private boolean success;

public void setProductCategoryService(ProductCategoryService productCategoryService) {
	this.productCategoryService = productCategoryService;
}

public boolean isSuccess(){
	return this.success;
}

public String getMsg(){
	return this.msg;
}

@Override
public String process() {
	try {
		productCategoryService.save(productCategory);
		msg = "Save Category Success!";
		success = true;
	} catch (Exception e) {
		log.debug("save category failed", e);
	}
	return "result";
}

@Override
public ProductCategory getModel() {
	return productCategory;
}

}
