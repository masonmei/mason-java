package org.personal.mason.repository;

import org.personal.mason.domain.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String> {

}
