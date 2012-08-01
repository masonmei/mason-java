package org.personal.mason.pb.server.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Account implements BaseEntity {

// Fields

private static final long serialVersionUID = 6713930970706941265L;
private Long id;
private Relation relation;
private String account;
private String email;
private String username;
private String secret;
private Timestamp createdate;
private Set<Relation> relations = new HashSet<Relation>(0);

// Constructors

/** default constructor */
public Account() {
}

/** minimal constructor */
public Account(String account, Timestamp createdate) {
	this.account = account;
	this.createdate = createdate;
}

/** full constructor */
public Account(Relation relation, String account, String email,
        String username, String secret, Timestamp createdate,
        Set<Relation> relations) {
	this.relation = relation;
	this.account = account;
	this.email = email;
	this.username = username;
	this.secret = secret;
	this.createdate = createdate;
	this.relations = relations;
}

// Property accessors
@Override
@Id
@GeneratedValue(strategy = IDENTITY)
public Long getId() {
	return this.id;
}

public void setId(Long id){
	this.id = id;
}

@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
public Relation getRelation() {
	return this.relation;
}

public void setRelation(Relation relation) {
	this.relation = relation;
}

public String getAccount() {
	return this.account;
}

public void setAccount(String account) {
	this.account = account;
}

public String getEmail() {
	return this.email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getUsername() {
	return this.username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getSecret() {
	return this.secret;
}

public void setSecret(String secret) {
	this.secret = secret;
}

public Timestamp getCreatedate() {
	return this.createdate;
}

public void setCreatedate(Timestamp createdate) {
	this.createdate = createdate;
}

@OneToMany(cascade = CascadeType.ALL)
public Set<Relation> getRelations() {
	return this.relations;
}

public void setRelations(Set<Relation> relations) {
	this.relations = relations;
}
}