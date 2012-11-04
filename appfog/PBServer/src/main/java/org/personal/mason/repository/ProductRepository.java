package org.personal.mason.repository;

import java.util.List;

import org.personal.mason.domain.Product;
import org.personal.mason.domain.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

List<Product> findByProductCategory(ProductCategory productCategory);

}
