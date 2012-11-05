package org.personal.mason.service.pb;

import java.util.ArrayList;
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
	List<Record> records = relation.getRecords();
	List<Record> udpatedRecords = new ArrayList<Record>();
	for (Record record : records) {
		udpatedRecords.add(recordRepository.save(record));
	}
	List<Resource> resources = relation.getResources();
	List<Resource> udpatedResources = new ArrayList<Resource>();
	for (Resource resource : resources) {
		udpatedResources.add(resourceRepository.save(resource));
	}
	relation.setRecords(udpatedRecords);
	relation.setResources(udpatedResources);
	return relationRepository.save(relation);
}

public boolean deleteRelation(Long id) {
	try {
		Relation relation = relationRepository.findOne(id);
		if (null != relation) {
			relationRepository.delete(id);
		}
		return true;
	} catch (Exception e) {
		return false;
	}
}

public boolean deleteRecord(Long id) {
	try {
		recordRepository.delete(id);
		return true;
	} catch (Exception e) {
		return false;
	}
}

public boolean deleteResource(Long id) {
	try {
		resourceRepository.delete(id);
		return true;
	} catch (Exception e) {
		return false;
	}
}

}
