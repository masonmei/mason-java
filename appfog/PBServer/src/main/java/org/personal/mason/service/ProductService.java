package org.personal.mason.service;

import java.util.List;

import org.personal.mason.domain.Product;
import org.personal.mason.domain.ProductCategory;
import org.personal.mason.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
@Autowired
private ProductRepository productRepository;

public List<Product> findAll() {
	return productRepository.findAll();
}

public Page<Product> findInScope(int page, int size) {
	PageRequest request = new PageRequest(page, size);
	return productRepository.findAll(request);
}

public Product findById(String id) {
	return productRepository.findOne(id);
}

public Product save(Product product) {
	return productRepository.save(product);
}

public void delete(Product product) {
	productRepository.delete(product);
}

public List<Product> findByCategory(ProductCategory category) {
	return productRepository.findByProductCategory(category);
}

public long count() {
	return productRepository.count();
}

public void delete(String id) {
	productRepository.delete(id);
}
}
