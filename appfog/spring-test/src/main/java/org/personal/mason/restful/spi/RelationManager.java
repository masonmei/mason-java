package org.personal.mason.restful.spi;

import java.util.List;
import java.util.Set;

import org.personal.mason.restful.dao.IDAO;
import org.personal.mason.restful.domain.Account;
import org.personal.mason.restful.domain.Basicinfo;
import org.personal.mason.restful.domain.Record;
import org.personal.mason.restful.domain.Relation;
import org.personal.mason.restful.domain.Resource;
import org.springframework.transaction.annotation.Transactional;

// @Service(value="relationManager")
public class RelationManager {

private IDAO<Relation> relationDao;
private IDAO<Basicinfo> basicInfoDao;
private IDAO<Resource> resourceDao;
private IDAO<Record> recordDao;

public void setRelationDao(IDAO<Relation> relationDao) {
	this.relationDao = relationDao;
}

public void setBasicInfoDao(IDAO<Basicinfo> basicInfoDao) {
	this.basicInfoDao = basicInfoDao;
}

public void setResourceDao(IDAO<Resource> resourceDao) {
	this.resourceDao = resourceDao;
}

public void setRecordDao(IDAO<Record> recordDao) {
	this.recordDao = recordDao;
}

@Transactional(readOnly = true)
public List<Relation> listAllRelations(Account account) {
	Relation exampleInstance = new Relation();
	exampleInstance.setAccount(account);
	List<Relation> accountRelations = relationDao.findByExample(exampleInstance);
	return accountRelations;
}

@Transactional
public Relation addRelation(Relation relation) {
	Basicinfo basicinfo = relation.getBasicinfo();
	if (basicinfo != null) {
		basicInfoDao.save(basicinfo);
	}
	relationDao.save(relation);
	return relation;
}

@Transactional
public Relation modifyRelation(Relation relation) {
	Basicinfo basicinfo = relation.getBasicinfo();
	if (null != basicinfo) {
		basicInfoDao.udpate(basicinfo);
	}
	Set<Record> records = relation.getRecords();
	for (Record record : records) {
		recordDao.udpate(record);
	}
	Set<Resource> resources = relation.getResources();
	for (Resource resource : resources) {
		resourceDao.udpate(resource);
	}
	relationDao.udpate(relation);
	return relation;
}

@Transactional
public boolean deleteRelation(Long id) {
	try {
		Relation relation = relationDao.findById(id);
		if (null != relation) {
			Basicinfo basicinfo = relation.getBasicinfo();
			Set<Record> records = relation.getRecords();
			for (Record record : records) {
				deleteRecord(record.getId());
			}
			Set<Resource> resources = relation.getResources();
			for (Resource resource : resources) {
				deleteResource(resource.getId());
			}
			relationDao.delete(relation);
			if (basicinfo != null) {
				basicInfoDao.delete(basicinfo);
			}
		}
		return true;
	} catch (Exception e) {
		return false;
	}
}

@Transactional
public boolean deleteRecord(Long id) {
	try {
		Record record = recordDao.findById(id);
		if (record != null) {
			recordDao.delete(record);
		}
		return true;
	} catch (Exception e) {
		return false;
	}
}

@Transactional
public boolean deleteResource(Long id) {
	try {
		Resource resource = resourceDao.findById(id);
		if (null != resource) {
			resourceDao.delete(resource);
		}
		return true;
	} catch (Exception e) {
		return false;
	}
}

}
