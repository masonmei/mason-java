package org.personal.mason.repository.common;

import org.personal.mason.domain.common.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {

}
