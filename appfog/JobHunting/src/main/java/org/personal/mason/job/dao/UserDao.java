package org.personal.mason.job.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.job.domain.User;

public class UserDao extends DAO<User> {

public UserDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected Class<User> getClazz() {
	return User.class;
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
