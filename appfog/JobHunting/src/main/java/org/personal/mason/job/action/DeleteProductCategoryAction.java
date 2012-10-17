package org.personal.mason.job.action;

import org.personal.mason.job.service.ProductCategoryService;

public class DeleteProductCategoryAction extends AbstractAction {

private static final long serialVersionUID = -8808602534894505625L;

private ProductCategoryService productCategoryService;
private boolean success;
private String msg;

public void setProductCategoryService(ProductCategoryService productCategoryService) {
	this.productCategoryService = productCategoryService;
}

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

@Override
public String process() {
	try {
		String parameter = request.getParameter("id");
		if (parameter != null) {
			productCategoryService.deleteById(Long.parseLong(parameter));
			msg = "delete success";
			success = true;
			return SUCCESS;
		}
		msg = "nothing to delete";
		success = true;
	} catch (NumberFormatException e) {
		log.debug("delete failed", e);
	}
	return null;
}

}
