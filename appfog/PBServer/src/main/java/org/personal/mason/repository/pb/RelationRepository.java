package org.personal.mason.repository.pb;

import org.personal.mason.domain.pb.Relation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RelationRepository extends MongoRepository<Relation, Long> {

}
