package org.personal.mason.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.personal.mason.domain.Company;
import org.personal.mason.domain.Product;
import org.personal.mason.service.CompanyService;
import org.personal.mason.service.ProductCategoryService;
import org.personal.mason.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Path("/product")
public class ProductResource {
@Autowired
private CompanyService companyService;

@Autowired
private ProductService productService;

@Autowired
private ProductCategoryService productCategoryService;

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Product> listCompanyProducts(@QueryParam("companyId") String companyId, @QueryParam("page") Integer page,
		@QueryParam("size") Integer size) {
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
	return companyProducts;
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/save")
@RequestMapping(value = "/save", method = RequestMethod.POST)
public Product saveCompanyProduct(@QueryParam("companyId") String companyId,
		@QueryParam("categoryId") String categoryId, Product Product) {
	Product product = new Product();
	product.setProductCategory(productCategoryService.findById(categoryId));
	productService.save(product);
	companyService.addProductToCompany(companyId, product);
	return product;
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/get")
public Product viewCompanyProduct(@QueryParam("id") String id) {
	return productService.findById(id);
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/delete")
public void deleteCompanyProduct(@QueryParam("id") String id, @QueryParam("companyId") String companyId) {
	Company company = companyService.findById(companyId);
	for (Product p : company.getProducts()) {
		if (p.getId().equals(id)) {
			company.getProducts().remove(p);
			break;
		}
	}
	companyService.save(company);
	productService.delete(id);
}
}
