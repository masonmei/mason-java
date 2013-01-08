package org.personal.mason.competition.repository;

import java.util.List;

import org.personal.mason.competition.domain.Account;
import org.personal.mason.competition.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

List<Category> findByAccountAndPublicPrivilege(Account account, boolean publicPrivilege);

List<Category> findByAccount(Account account);

Page<Category> findByAccount(Account account, Pageable pageable);
}
