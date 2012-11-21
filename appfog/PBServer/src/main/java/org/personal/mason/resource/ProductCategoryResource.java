package org.personal.mason.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.personal.mason.domain.ProductCategory;
import org.personal.mason.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/category")
public class ProductCategoryResource {
@Autowired
private ProductCategoryService productCategoryService;

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<ProductCategory> listCategory() {
	List<ProductCategory> categories = productCategoryService.findAll();
	return categories;
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/create")
public List<ProductCategory> addCompanyProduct(@QueryParam("parentCategory") String id,
		@QueryParam("categoryName") String categoryName) {
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
