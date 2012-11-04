package org.personal.mason.repository;

import java.util.List;

import org.personal.mason.domain.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {
List<ProductCategory> findByRoot(boolean root);
}
