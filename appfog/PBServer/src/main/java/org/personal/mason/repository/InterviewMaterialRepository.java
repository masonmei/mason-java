package org.personal.mason.repository;

import org.personal.mason.domain.InterviewMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterviewMaterialRepository extends MongoRepository<InterviewMaterial, String> {

}
