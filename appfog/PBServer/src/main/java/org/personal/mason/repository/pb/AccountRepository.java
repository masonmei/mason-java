package org.personal.mason.repository.pb;

import org.personal.mason.domain.pb.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

Account findByEmailOrAccount(String email, String account);

Account findByEmail(String email);

Account findByAccount(String account);

}
