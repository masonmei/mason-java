package org.personal.mason.job.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Job entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

private static final long serialVersionUID = -7876411198043833657L;
// Fields

private Long id;
private String email;
private String password;
private String name;

// Constructors

/** default constructor */
public User() {
}

/** minimal constructor */
public User(String email, String password) {
	this.email = email;
	this.password = password;
}

/** full constructor */
public User(String email, String password, String name) {
	this.email = email;
	this.password = password;
	this.name = name;
}

// Property accessors
@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name = "id", unique = true, nullable = false)
public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

@Column(name = "email", nullable = false, length = 100)
public String getEmail() {
	return this.email;
}

public void setEmail(String email) {
	this.email = email;
}

@Column(name = "password", nullable = false, length = 100)
public String getPassword() {
	return this.password;
}

public void setPassword(String password) {
	this.password = password;
}

@Column(name = "name")
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public static User createWithEmail(String email) {
	if (email != null) {
		User user = new User();
		user.setEmail(email);
		return user;
	}
	return null;
}

}