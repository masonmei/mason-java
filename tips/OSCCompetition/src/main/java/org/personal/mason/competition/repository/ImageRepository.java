package org.personal.mason.competition.repository;

import org.personal.mason.competition.domain.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {

}
