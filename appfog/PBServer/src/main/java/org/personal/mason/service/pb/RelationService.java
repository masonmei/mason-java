package org.personal.mason.service.pb;

import java.util.List;

import org.personal.mason.domain.pb.Account;
import org.personal.mason.domain.pb.Record;
import org.personal.mason.domain.pb.Relation;
import org.personal.mason.domain.pb.Resource;
import org.personal.mason.repository.pb.AccountRepository;
import org.personal.mason.repository.pb.RecordRepository;
import org.personal.mason.repository.pb.RelationRepository;
import org.personal.mason.repository.pb.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationService {

@Autowired
private AccountRepository accountRepository;

@Autowired
private RelationRepository relationRepository;

@Autowired
private RecordRepository recordRepository;

@Autowired
private ResourceRepository resourceRepository;

public List<Relation> listAllRelations(Account account) {
	Account persistAccount = accountRepository.findOne(account.getId());
	return persistAccount.getRelations();
}

public Relation addRelation(Relation relation, Account account) {
	Account persistAccount = accountRepository.findOne(account.getId());
	Relation persistRelation = relationRepository.save(relation);
	persistAccount.getRelations().add(persistRelation);
	accountRepository.save(persistAccount);
	return persistRelation;
}

public Relation modifyRelation(Relation relation) {
	return relationRepository.save(relation);
}

public Record addRecord(Record record, Relation relation) {
	Relation persist = relationRepository.findOne(relation.getId());
	Record saved = recordRepository.save(record);
	if (saved != null) {
		persist.getRecords().add(saved);
		relationRepository.save(persist);
		return saved;
	}
	return null;
}

public Resource addResource(Resource resource, Relation relation) {
	Relation persist = relationRepository.findOne(relation.getId());
	Resource saved = resourceRepository.save(resource);
	if (saved != null) {
		persist.getResources().add(saved);
		relationRepository.save(persist);
		return saved;
	}
	return null;
}

public boolean deleteRelation(String id) {
	try {
		Relation relation = relationRepository.findOne(id);
		if (null != relation) {
			resourceRepository.delete(relation.getResources());
			recordRepository.delete(relation.getRecords());
			relationRepository.delete(id);
		}
		return true;
	} catch (Exception e) {
		return false;
	}
}

public boolean deleteRecord(String id, Relation relation) {
	try {
		Relation persist = relationRepository.findOne(relation.getId());
		for (Record record : persist.getRecords()) {
			if (record.getId().equals(id)) {
				persist.getRecords().remove(record);
				relationRepository.save(persist);
				recordRepository.delete(id);
				return true;

			}
		}
		return false;
	} catch (Exception e) {
		return false;
	}
}

public boolean deleteResource(String id, Relation relation) {
	try {
		Relation persist = relationRepository.findOne(relation.getId());
		for (Resource resource : persist.getResources()) {
			if (resource.getId().equals(id)) {
				persist.getResources().remove(resource);
				relationRepository.save(persist);
				resourceRepository.delete(id);
				return true;
			}
		}
		return false;
	} catch (Exception e) {
		return false;
	}
}

public Relation findRelationById(String relationId) {
	return relationRepository.findOne(relationId);
}

}
