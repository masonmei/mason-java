package org.personal.mason.dto;

public class ProductForm {

private String productCategoryId;
private String productName;
private String shortDesc;
private String description;

public String getProductCategoryId() {
	return productCategoryId;
}

public void setProductCategoryId(String productCategoryId) {
	this.productCategoryId = productCategoryId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getShortDesc() {
	return shortDesc;
}

public void setShortDesc(String shortDesc) {
	this.shortDesc = shortDesc;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

}
