package org.personal.mason.service;

import java.util.List;

import org.jasypt.util.password.PasswordEncryptor;
import org.personal.mason.domain.User;
import org.personal.mason.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
private UserRepository userRepository;
@Autowired
private PasswordEncryptor passwordEncryptor;

public List<User> findAll() {
	return userRepository.findAll();
}

public User findById(String id) {
	return userRepository.findOne(id);
}

public User save(User user) {
	return userRepository.save(user);
}

public void delete(User user) {
	userRepository.delete(user);
}

public User findByEmail(String email) {
	return userRepository.findByEmail(email);
}

public long count() {
	return userRepository.count();
}

public boolean verifyUser(User user) {
	User persistUser = userRepository.findByEmail(user.getEmail());
	return passwordEncryptor.checkPassword(user.getPassword(), persistUser.getPassword());
}

public User register(User user){
	user.setPassword(passwordEncryptor.encryptPassword(user.getPassword()));
	return userRepository.save(user);
}
}
