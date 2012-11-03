package org.personal.mason.repository;

import org.personal.mason.domain.News;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<News, String> {

}
