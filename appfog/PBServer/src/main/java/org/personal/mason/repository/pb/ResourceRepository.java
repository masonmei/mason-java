package org.personal.mason.repository.pb;

import org.personal.mason.domain.pb.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResourceRepository extends MongoRepository<Resource, Long> {

}
