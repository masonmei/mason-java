package org.personal.mason.job.service;

import org.jasypt.util.password.PasswordEncryptor;
import org.personal.mason.job.dao.UserDao;
import org.personal.mason.job.domain.User;
import org.springframework.transaction.annotation.Transactional;

public class UserService extends DefaultService<User> {

private UserDao userDao;

private PasswordEncryptor passwordEncryptor;

public void setPasswordEncryptor(PasswordEncryptor passwordEncryptor) {
	this.passwordEncryptor = passwordEncryptor;
}

public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
}

public UserService() {
}

public boolean verifyUser(User user) {
	String password = userDao.getPassword(user);

	return passwordEncryptor.checkPassword(user.getPassword(), password);
}

@Override
@Transactional
public void save(User entity) {
	entity.setPassword(passwordEncryptor.encryptPassword(entity.getPassword()));
	super.save(entity);
}
}
