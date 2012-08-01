package org.personal.mason.pb.server.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.personal.mason.pb.server.api.model.PBAccount;
import org.personal.mason.pb.server.api.model.PBBasicInfo;
import org.personal.mason.pb.server.api.model.PBRecord;
import org.personal.mason.pb.server.api.model.PBRelation;
import org.personal.mason.pb.server.api.model.PBResource;
import org.personal.mason.pb.server.domain.Account;
import org.personal.mason.pb.server.domain.Basicinfo;
import org.personal.mason.pb.server.domain.Record;
import org.personal.mason.pb.server.domain.Relation;
import org.personal.mason.pb.server.domain.Resource;

public class ModelConvetor {

public static PBAccount convertAccount(Account acc) {
	PBAccount account = new PBAccount();
	account.setId(acc.getId());
	account.setAccount(acc.getAccount());
	account.setEmail(acc.getEmail());
	account.setSecret(acc.getSecret());
	account.setUsername(acc.getUsername());
	account.setCreatedate(acc.getCreatedate());

	PBRelation relation = convertRelation(acc.getRelation());
	account.setRelation(relation);

	return account;
}

public static Account unConvertAccount(PBAccount account) {
	Account acc = new Account();
	acc.setAccount(account.getAccount());
	acc.setId(account.getId());
	acc.setEmail(account.getEmail());
	acc.setSecret(MD5Tools.secretPassword(account.getSecret()));
	acc.setUsername(account.getUsername());
	acc.setCreatedate(account.getCreatedate());

	PBRelation relation = account.getRelation();
	if (relation != null) {
		Relation rel = unConvertRelation(relation, null);
		acc.setRelation(rel);
	}

	return acc;
}

public static Account lazyUnConvertAccount(PBAccount account) {
	Account acc = new Account();
	acc.setAccount(account.getAccount());
	acc.setId(account.getId());
	acc.setEmail(account.getEmail());
	acc.setSecret(account.getSecret());
	acc.setUsername(account.getUsername());
	acc.setCreatedate(account.getCreatedate());
	return acc;
}

public static Set<PBRelation> convertRelations(List<Relation> rs) {
	Set<PBRelation> relations = new HashSet<PBRelation>();
	if (rs != null) {
		for (Relation rel : rs) {
			PBRelation relation = convertRelation(rel);
			relations.add(relation);
		}
	}
	return relations;
}

public static Set<Relation> unConvertRelations(Set<PBRelation> relations, Account acc) {
	Set<Relation> rs = new HashSet<Relation>();
	if (relations != null) {
		for (PBRelation relation : relations) {
			Relation rel = unConvertRelation(relation, acc);
			rs.add(rel);
		}
	}
	return rs;
}

public static PBRelation convertRelation(Relation rel) {
	PBRelation relation = new PBRelation();
	relation.setId(rel.getId());
	relation.setRelationtype(rel.getRelationtype());
	relation.setExtendinfo(rel.getExtendinfo());

	Basicinfo bi = rel.getBasicinfo();
	PBBasicInfo basicinfo = convertBasicInfo(bi);
	relation.setBasicinfo(basicinfo);

	for (Record rec : rel.getRecords()) {
		PBRecord record = convertRecord(rec);
		relation.getRecords().add(record);
	}

	for (Resource res : rel.getResources()) {
		PBResource resource = convertResource(res);
		relation.getResources().add(resource);
	}

	return relation;
}

public static Relation unConvertRelation(PBRelation relation, Account acc) {
	Relation rel = new Relation();
	rel.setId(relation.getId());
	rel.setRelationtype(relation.getRelationtype());
	rel.setExtendinfo(relation.getExtendinfo());

	Basicinfo bi = unConvertBasicInfo(relation.getBasicinfo());
	rel.setBasicinfo(bi);

	for (PBRecord record : relation.getRecords()) {
		Record rec = unConvertRecord(record, rel);
		rel.getRecords().add(rec);
	}

	for (PBResource resource : relation.getResources()) {
		Resource res = unConvertResource(resource, rel);
		rel.getResources().add(res);
	}
	if (null != acc) {
		rel.setAccount(acc);
	}
	return rel;
}

public static PBBasicInfo convertBasicInfo(Basicinfo bi) {
	PBBasicInfo basicinfo = new PBBasicInfo();
	basicinfo.setAddresses(bi.getAddresses());
	basicinfo.setBirth(bi.getBirth());
	basicinfo.setCellphones(bi.getCellphones());
	basicinfo.setContacts(bi.getContacts());
	basicinfo.setFavors(bi.getFavors());
	basicinfo.setGoodat(bi.getGoodat());
	basicinfo.setId(bi.getId());
	basicinfo.setName(bi.getName());
	basicinfo.setNation(bi.getNation());
	basicinfo.setNickname(bi.getNickname());
	basicinfo.setPhones(bi.getPhones());
	basicinfo.setTaboos(bi.getTaboos());
	basicinfo.setUsednames(bi.getUsednames());
	return basicinfo;
}

public static Basicinfo unConvertBasicInfo(PBBasicInfo basicinfo) {
	Basicinfo bi = new Basicinfo();
	bi.setAddresses(basicinfo.getAddresses());
	bi.setBirth(basicinfo.getBirth());
	bi.setCellphones(basicinfo.getCellphones());
	bi.setContacts(basicinfo.getContacts());
	bi.setFavors(basicinfo.getFavors());
	bi.setGoodat(basicinfo.getGoodat());
	bi.setId(basicinfo.getId());
	bi.setName(basicinfo.getName());
	bi.setNation(basicinfo.getNation());
	bi.setNickname(basicinfo.getNickname());
	bi.setPhones(basicinfo.getPhones());
	bi.setTaboos(basicinfo.getTaboos());
	bi.setUsednames(basicinfo.getUsednames());
	return bi;
}

public static PBRecord convertRecord(Record rec) {
	PBRecord record = new PBRecord();
	record.setId(record.getId());
	record.setStartdate(rec.getStartdate());
	record.setEnddate(rec.getEnddate());
	record.setDescription(rec.getDescription());
	record.setAccomplishment(rec.getAccomplishment());
	record.setType(rec.getType());
	return record;
}

public static Record unConvertRecord(PBRecord record, Relation rel) {
	Record rec = new Record();
	rec.setId(record.getId());
	rec.setStartdate(record.getStartdate());
	rec.setEnddate(record.getEnddate());
	rec.setDescription(record.getDescription());
	rec.setAccomplishment(record.getAccomplishment());
	rec.setType(record.getType());
	return rec;
}

public static PBResource convertResource(Resource res) {
	PBResource resource = new PBResource();
	resource.setId(res.getId());
	resource.setResourcename(res.getResourcename());
	resource.setDescription(res.getDescription());
	resource.setBuilddate(res.getBuilddate());
	return resource;
}

public static Resource unConvertResource(PBResource resource, Relation rel) {
	Resource res = new Resource();
	res.setId(resource.getId());
	res.setResourcename(resource.getResourcename());
	res.setDescription(resource.getDescription());
	res.setBuilddate(resource.getBuilddate());
	return res;
}

}
