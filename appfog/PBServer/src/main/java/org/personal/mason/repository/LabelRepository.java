package org.personal.mason.repository;

import org.personal.mason.domain.Label;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LabelRepository extends MongoRepository<Label, String> {

	Label findByLabelName(String labelName);

}
