package org.personal.mason.job.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.personal.mason.job.domain.User;

public class UserDao extends DAO<User> {

public UserDao() {
}

public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

public void setClazz(Class<User> clazz) {
	this.clazz = clazz;
}

public String getPassword(User user) {
	User userWithEmail = User.createWithEmail(user.getEmail());
	if (userWithEmail != null) {
		List<User> users = this.findByExample(userWithEmail, 0, 1);
		if (users != null && users.size() > 0) {
			return users.get(0).getPassword();
		}
	}
	return null;
}
}
