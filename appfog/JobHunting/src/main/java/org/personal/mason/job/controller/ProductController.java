package org.personal.mason.job.controller;

import java.util.List;
import java.util.Map;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Product;
import org.personal.mason.job.service.CompanyService;
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

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCompanyProductsList(@RequestParam("companyId") Long companyId, Integer start, Integer length, Map<String, Object> map) {
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

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCompanyNews(@RequestParam("companyId") Long companyId, Product product) {
		Company company = companyService.findById(companyId);
		product.setCompany(company);
		productService.save(product);
		return null;
	}

	@RequestMapping(value = "/delete")
	public String deleteNews(@RequestParam("id") Long id) {
		productService.deleteById(id);
		return null;
	}
}
