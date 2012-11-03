package org.personal.mason.repository;

import org.personal.mason.domain.Interview;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterviewRepository extends MongoRepository<Interview, String> {

}
