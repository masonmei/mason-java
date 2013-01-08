package org.personal.mason.competition.repository;

import org.personal.mason.competition.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

Account findByEmailOrAccount(String email, String account);

Account findByEmail(String email);

Account findByAccount(String account);

}
