package org.personal.mason.controller;

import java.util.List;
import java.util.Map;

import org.personal.mason.domain.ProductCategory;
import org.personal.mason.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/category")
public class ProductCategoryController {
@Autowired
private ProductCategoryService productCategoryService;

@RequestMapping(value = "/list", method = RequestMethod.GET)
public @ResponseBody
List<ProductCategory> listCompanyProducts(Map<String, Object> map) {
	List<ProductCategory> categories = productCategoryService.findAll();
	return categories;
}

@RequestMapping(value = "/create", method = RequestMethod.GET)
public @ResponseBody
List<ProductCategory> addCompanyProduct(@RequestParam("parentCategory") String id,
		@RequestParam("categoryName") String categoryName) {
	ProductCategory findById = productCategoryService.findById(id);
	ProductCategory category = new ProductCategory();
	category.setCategoryName(categoryName);
	productCategoryService.save(category);
	if (findById != null) {
		findById.getProductCategories().add(category);
		productCategoryService.save(findById);
	}
	return productCategoryService.findAll();
}

}
