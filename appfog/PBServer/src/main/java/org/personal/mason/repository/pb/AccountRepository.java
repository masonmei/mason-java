package org.personal.mason.repository.pb;

import org.personal.mason.domain.pb.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, Long> {

Account findByEmailOrAccount(String email, String account);

Account findByEmailAndSecret(String email, String secret);

Account findByAccountAndSecret(String email, String secret);

}
