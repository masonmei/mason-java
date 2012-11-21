package org.personal.mason.repository.pb;

import org.personal.mason.domain.pb.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecordRepository extends MongoRepository<Record, String> {

}
