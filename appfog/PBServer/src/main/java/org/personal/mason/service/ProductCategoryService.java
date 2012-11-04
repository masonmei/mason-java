package org.personal.mason.service;

import java.util.List;

import org.personal.mason.domain.ProductCategory;
import org.personal.mason.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {
@Autowired
private ProductCategoryRepository productCategoryRepository;

public List<ProductCategory> findAll() {
	return productCategoryRepository.findAll();
}

public ProductCategory findById(String id) {
	return productCategoryRepository.findOne(id);
}

public ProductCategory save(ProductCategory productCategory) {
	return productCategoryRepository.save(productCategory);
}

public void delete(ProductCategory productCategory) {
	productCategoryRepository.delete(productCategory);
}

public List<ProductCategory> getProductCategoryRoots() {
	return productCategoryRepository.findByRoot(true);
}
}
