package org.personal.mason.restful.spi;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.restful.dao.DAO;
import org.personal.mason.restful.dao.IDAO;
import org.personal.mason.restful.domain.Account;
import org.personal.mason.restful.domain.Basicinfo;
import org.personal.mason.restful.domain.Record;
import org.personal.mason.restful.domain.Relation;
import org.personal.mason.restful.domain.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RelationManager {

private EntityManager entityManager;

@PersistenceContext
private void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

private IDAO<Relation> relationDao = new DAO<Relation>(entityManager);
private IDAO<Basicinfo> basicInfoDao = new DAO<Basicinfo>(entityManager);
private IDAO<Resource> resourceDao = new DAO<Resource>(entityManager);
private IDAO<Record> recordDao = new DAO<Record>(entityManager);

@Transactional(readOnly = true)
public List<Relation> listAllRelations(Account account) {
	List<Relation> accountRelations = relationDao.getBy(Relation.class, "account", account.getId());
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
		basicInfoDao.saveOrUpdate(basicinfo);
	}
	Set<Record> records = relation.getRecords();
	for (Record record : records) {
		recordDao.saveOrUpdate(record);
	}
	Set<Resource> resources = relation.getResources();
	for (Resource resource : resources) {
		resourceDao.saveOrUpdate(resource);
	}
	Relation savedRelation = relationDao.saveOrUpdate(relation);
	return savedRelation;
}

@Transactional
public boolean deleteRelation(Long id) {
	try {
		Relation relation = relationDao.get(Relation.class, id);
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
			relationDao.del(relation);
			if (basicinfo != null) {
				basicInfoDao.del(basicinfo);
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
		Record record = recordDao.get(Record.class, id);
		if (record != null) {
			recordDao.del(record);
		}
		return true;
	} catch (Exception e) {
		return false;
	}
}

@Transactional
public boolean deleteResource(Long id) {
	try {
		Resource resource = resourceDao.get(Resource.class, id);
		if (null != resource) {
			resourceDao.del(resource);
		}
		return true;
	} catch (Exception e) {
		return false;
	}
}

@Transactional(readOnly = true)
public List<Relation> getRelationsByName(Account account, String name) {
	String queryStr = "select distinct re from Relation as re inner join re.basicinfo as bi where re.account = ? and (bi.name like concat('%','?','%') or bi.nickname like concat('%','?','%') or bi.usednames like concat('%','?','%'))";
	List<Relation> relationsByName = relationDao.query(queryStr, Arrays.asList(new Object[] { account.getId(), name, name, name }));
	return relationsByName;
}

@Transactional(readOnly = true)
public List<Relation> getRelationsByCellPhone(Account account, String cellphone) {
	String queryStr = "select distinct re from Relation as re inner join re.basicinfo as bi where re.account = ? and bi.cellphones like concat('%','?','%')";
	List<Relation> relationsByName = relationDao.query(queryStr, Arrays.asList(new Object[] { account.getId(), cellphone }));
	return relationsByName;
}

@Transactional(readOnly = true)
public List<Relation> getRelationsByPhone(Account account, String phone) {
	String queryStr = "select distinct re from Relation as re inner join re.basicinfo as bi where re.account = ? and bi.phones like concat('%','?','%')";
	List<Relation> relationsByName = relationDao.query(queryStr, Arrays.asList(new Object[] { account.getId(), phone }));
	return relationsByName;
}

@Transactional(readOnly = true)
public List<Relation> getRelationsByContact(Account account, String contact) {
	String queryStr = "select distinct re from Relation as re inner join re.basicinfo as bi where re.account = ? and bi.contacts like concat('%','?','%')";
	List<Relation> relationsByName = relationDao.query(queryStr, Arrays.asList(new Object[] { account.getId(), contact }));
	return relationsByName;
}

@Transactional(readOnly = true)
public List<Relation> getRelationsByFavors(Account account, String... favors) {
	String queryStr = "select distinct re from Relation as re inner join re.basicinfo as bi where re.account = ? and bi.favors like concat('%','?','%')";
	StringBuilder builder = new StringBuilder();
	for (String favor : favors) {
		builder.append(favor);
		builder.append("%");
	}
	if (builder.length() > 0) {
		builder.deleteCharAt(builder.length() - 1);
	}
	List<Relation> relationsByName = relationDao.query(queryStr, Arrays.asList(new Object[] { account.getId(), builder.toString() }));
	return relationsByName;
}

@Transactional(readOnly = true)
public List<Relation> getRelationsByGoodAts(Account account, String... goodAts) {
	String queryStr = "select distinct re from Relation as re inner join re.basicinfo as bi where re.account = ? and bi.goodat like concat('%','?','%') ";
	StringBuilder builder = new StringBuilder();
	for (String goodat : goodAts) {
		builder.append(goodat);
		builder.append("%");
	}
	if (builder.length() > 0) {
		builder.deleteCharAt(builder.length() - 1);
	}
	List<Relation> relationsByName = relationDao.query(queryStr, Arrays.asList(new Object[] { account.getId(), builder.toString() }));
	return relationsByName;
}

@Transactional(readOnly = true)
public List<Relation> getRelationsByAccomplishment(Account account, String accomplishment) {
	String queryStr = "select distinct re from Relation as re inner join re.records as rc where re.account=? and rc.accomplishment like concat('%', '?', '%')";
	List<Relation> relationsByName = relationDao.query(queryStr, Arrays.asList(new Object[] { account.getId(), accomplishment }));
	return relationsByName;
}

@Transactional(readOnly = true)
public List<Relation> getRelationsByTypeAndAccomplishment(Account account, String type, String accomplishment) {
	String queryStr = "select distinct re from Relation as re inner join re.records as rc where re.account=? and rc.type=? and rc.accomplishment like concat('%', '?', '%')";
	List<Relation> relationsByName = relationDao.query(queryStr, Arrays.asList(new Object[] { account.getId(), type, accomplishment }));
	return relationsByName;
}

@Transactional(readOnly = true)
public List<Relation> getRelationsByPersonalRecordDes(Account account, String recordDes) {
	String queryStr = "select distinct re from Relation as re inner join re.records as rc where re.account=? and rc.description like concat('%', '?', '%')";
	List<Relation> relationsByName = relationDao.query(queryStr, Arrays.asList(new Object[] { account.getId(), recordDes }));
	return relationsByName;
}

@Transactional(readOnly = true)
public List<Relation> getRelationsByTypeAndPersonalRecordDes(Account account, String type, String recordDes) {
	String queryStr = "select distinct re from Relation as re inner join re.records as rc where re.account=? and rc.type=? and rc.description like concat('%', '?', '%')";
	List<Relation> relationsByName = relationDao.query(queryStr, Arrays.asList(new Object[] { account.getId(), type, recordDes }));
	return relationsByName;
}

@Transactional(readOnly = true)
public List<Relation> getRelationsByResourceDes(Account account, String resourceDes) {
	String queryStr = "select distinct re from Relation as re inner join re.resources as rc where re.account=? and rc.description like concat('%', '?', '%')";
	List<Relation> relationsByName = relationDao.query(queryStr, Arrays.asList(new Object[] { account.getId(), resourceDes }));
	return relationsByName;
}

}
