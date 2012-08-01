package org.personal.mason.pb.server.service;

import org.personal.mason.pb.server.domain.Account;

public interface IAccountManager {

public Account createAccount(Account account);

public Account validateAccount(Account account);

public Account modifyAccount(Account account);

}
