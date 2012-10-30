package org.personal.mason.job.domain;

// Generated Oct 25, 2012 9:29:03 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements java.io.Serializable {

private static final long serialVersionUID = -3539244245279221541L;
private Long id;
private String email;
private String name;
private String password;

public User() {
}

public User(String email, String password) {
	this.email = email;
	this.password = password;
}

public User(String email, String name, String password) {
	this.email = email;
	this.name = name;
	this.password = password;
}

@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name = "id", unique = true, nullable = false)
public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

@Column(name = "email", unique = true, nullable = false, length = 100)
public String getEmail() {
	return this.email;
}

public void setEmail(String email) {
	this.email = email;
}

@Column(name = "name")
public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}

@Column(name = "password", nullable = false, length = 100)
public String getPassword() {
	return this.password;
}

public void setPassword(String password) {
	this.password = password;
}

public static User createWithEmail(String email) {
	User user = new User();
	user.setEmail(email);
	return user;
}

}
