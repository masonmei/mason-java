package org.personal.mason.domain.pb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */
@Document
@XmlRootElement
public class Account {

@Id
private String id;
@DBRef
private Relation relation;
@Indexed(unique = true)
private String account;
@Indexed(unique = true)
private String email;
private String username;
private String secret;
private Date createdate;

@DBRef
private List<Relation> relations = new ArrayList<Relation>(0);

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public Relation getRelation() {
	return relation;
}

public void setRelation(Relation relation) {
	this.relation = relation;
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

public List<Relation> getRelations() {
	return relations;
}

public void setRelations(List<Relation> relations) {
	this.relations = relations;
}

}