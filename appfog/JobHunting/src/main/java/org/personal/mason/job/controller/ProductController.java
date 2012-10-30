package org.personal.mason.job.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Product;
import org.personal.mason.job.domain.ProductCategory;
import org.personal.mason.job.service.CompanyService;
import org.personal.mason.job.service.ProductCategoryService;
import org.personal.mason.job.service.ProductService;
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
public String listCompanyProducts(@RequestParam("companyId") Long companyId, Integer start, Integer length,
		Map<String, Object> map) {
	Company company = companyService.findById(companyId);
	if (start == null || start < 0) {
		start = 0;
	}

	if (length == null || length <= 0) {
		length = 10;
	}
	List<Product> companyProducts = productService.findCompanyProducts(company, start, length);
	map.put("company", company);
	map.put("companyProducts", companyProducts);
	return "products";
}

@RequestMapping(value = "/add", method = RequestMethod.GET)
public String addCompanyProduct(@RequestParam("companyId") Long companyId, Map<String, Object> map) {
	map.put("companyId", companyId);
	map.put("product", new Product());
	List<ProductCategory> roots = productCategoryService.getProductCategoryRoots();
	Map<String, ProductCategory> categories = new HashMap<String, ProductCategory>();
	if (roots != null) {
		for (ProductCategory productCategory : roots) {
			categories.put(productCategory.getCategoryName(), productCategory);
		}
	}
	map.put("categories", categories);
	return "product_edit";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveCompanyProduct(@RequestParam("companyId") Long companyId, Product product) {
	Company company = companyService.findById(companyId);
	product.setCompany(company);
	product.setProductCategory(productCategoryService.findById(product.getProductCategory().getId()));
	productService.save(product);
	return "redirect:/product/list?companyId=" + companyId;
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewCompanyProduct(@RequestParam("id") Long id, Map<String, Object> map) {
	Product product = productService.findById(id);
	map.put("product", product);
	return "product";
}

@RequestMapping(value = "/delete")
public String deleteCompanyProduct(@RequestParam("id") Long id, @RequestParam("companyId") Long companyId) {
	productService.deleteById(id);
	return "redirect:/product/list?companyId=" + companyId;
}
}
