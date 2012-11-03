package org.personal.mason.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class SystemInitialize {
@Autowired
private MongoTemplate mongoTemplate;
public void init() {
	
}
}
