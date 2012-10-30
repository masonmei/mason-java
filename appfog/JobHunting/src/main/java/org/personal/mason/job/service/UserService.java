package org.personal.mason.job.service;

import javax.annotation.Resource;

import org.jasypt.util.password.PasswordEncryptor;
import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.UserDao;
import org.personal.mason.job.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService extends DefaultService<User> {

@Resource
private UserDao userDao;

@Autowired
private PasswordEncryptor passwordEncryptor;

public UserService() {
}

public void setPasswordEncryptor(PasswordEncryptor passwordEncryptor) {
	this.passwordEncryptor = passwordEncryptor;
}

public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
}

@Override
public DAO<User> getDao() {
	return userDao;
}

@Transactional(readOnly = true)
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
