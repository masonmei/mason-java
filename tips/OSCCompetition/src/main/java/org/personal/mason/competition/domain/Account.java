package org.personal.mason.competition.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */
@Document
public class Account {

@Id
private String id;
@Indexed(unique = true)
private String account;
@Indexed(unique = true)
private String email;
private String username;
private String secret;
private Date createdate;

@DBRef
private List<Category> categories = new ArrayList<Category>();

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getAccount() {
	return account;
}

public void setAccount(String account) {
	this.account = account;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getSecret() {
	return secret;
}

public void setSecret(String secret) {
	this.secret = secret;
}

public Date getCreatedate() {
	return createdate;
}

public void setCreatedate(Date createdate) {
	this.createdate = createdate;
}

public List<Category> getCategories() {
	return categories;
}

public void setCategories(List<Category> categories) {
	this.categories = categories;
}
}