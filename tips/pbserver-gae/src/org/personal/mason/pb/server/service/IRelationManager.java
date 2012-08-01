package org.personal.mason.pb.server.service;

import java.util.List;

import org.personal.mason.pb.server.domain.Account;
import org.personal.mason.pb.server.domain.Relation;

public interface IRelationManager {

public List<Relation> listAllRelations(Account account);

public Relation addRelation(Relation relation);

public Relation modifyRelation(Relation relation);

public boolean deleteRelation(Long id);

public boolean deleteRecord(Long id);

public boolean deleteResource(Long id);

public List<Relation> getRelationsByName(Account account, String name);

public List<Relation> getRelationsByCellPhone(Account account, String cellphone);

public List<Relation> getRelationsByPhone(Account account, String phone);

public List<Relation> getRelationsByContact(Account account, String contact);

public List<Relation> getRelationsByFavors(Account account, String... favors);

public List<Relation> getRelationsByGoodAts(Account account, String... goodAts);

public List<Relation> getRelationsByAccomplishment(Account account, String accomplishment);

public List<Relation> getRelationsByTypeAndAccomplishment(Account account, String type, String accomplishment);

public List<Relation> getRelationsByPersonalRecordDes(Account account, String recordDes);

public List<Relation> getRelationsByTypeAndPersonalRecordDes(Account account, String type, String recordDes);

public List<Relation> getRelationsByResourceDes(Account account, String resourceDes);
}
