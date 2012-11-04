package org.personal.mason.controller;

import java.util.List;
import java.util.Map;

import org.personal.mason.domain.Company;
import org.personal.mason.domain.Product;
import org.personal.mason.dto.ProductForm;
import org.personal.mason.service.CompanyService;
import org.personal.mason.service.ProductCategoryService;
import org.personal.mason.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
@Autowired
private CompanyService companyService;

@Autowired
private ProductService productService;

@Autowired
private ProductCategoryService productCategoryService;

public void setCompanyService(CompanyService companyService) {
	this.companyService = companyService;
}

public void setProductService(ProductService productService) {
	this.productService = productService;
}

public void setProductCategoryService(ProductCategoryService productCategoryService) {
	this.productCategoryService = productCategoryService;
}

@RequestMapping(value = "/list", method = RequestMethod.GET)
public String listCompanyProducts(@RequestParam("companyId") String companyId, Integer page, Integer size,
		Map<String, Object> map) {
	Company company = companyService.findById(companyId);
	if (page == null || page < 0) {
		page = 0;
	}

	if (size == null || size <= 0) {
		size = 10;
	}
	List<Product> companyProducts;

	if (company.getNewses().size() <= (page + 1) * 10) {
		companyProducts = company.getProducts().subList(page * size, company.getProducts().size());
	} else {
		companyProducts = company.getProducts().subList(page * size, (page + 1) * size);
	}
	map.put("company", company);
	map.put("companyProducts", companyProducts);
	return "products";
}

@RequestMapping(value = "/add", method = RequestMethod.GET)
public String addCompanyProduct(@RequestParam("companyId") String companyId, Map<String, Object> map) {
	map.put("companyId", companyId);
	map.put("product", new ProductForm());
	return "product_edit";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveCompanyProduct(@RequestParam("companyId") String companyId, ProductForm productForm) {
	Product product = new Product(); 
	product.setProductCategory(productCategoryService.findById(productForm.getProductCategoryId()));
	product.setDescription(productForm.getDescription());
	product.setProductName(productForm.getProductName());
	product.setShortDesc(productForm.getShortDesc());
	productService.save(product);
	companyService.addProductToCompany(companyId, product);
	return "redirect:/product/list?companyId=" + companyId;
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewCompanyProduct(@RequestParam("id") String id, Map<String, Object> map) {
	Product product = productService.findById(id);
	map.put("product", product);
	return "product";
}

@RequestMapping(value = "/delete")
public String deleteCompanyProduct(@RequestParam("id") String id, @RequestParam("companyId") String companyId) {
	productService.delete(id);
	return "redirect:/product/list?companyId=" + companyId;
}
}
