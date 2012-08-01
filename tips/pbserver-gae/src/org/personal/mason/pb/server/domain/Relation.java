package org.personal.mason.pb.server.domain;

import static javax.persistence.GenerationType.IDENTITY;

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
 * Relation entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Relation implements BaseEntity {

// Fields

private static final long serialVersionUID = 7115261964893523750L;

private Long id;
private Basicinfo basicinfo;
private Account account;
private String relationtype;
private String extendinfo;
private Set<Record> records = new HashSet<Record>(0);
private Set<Resource> resources = new HashSet<Resource>(0);

// Constructors

/** default constructor */
public Relation() {
}

/** full constructor */
public Relation(Basicinfo basicinfo, Account account, String relationtype,
        String extendinfo, Set<Record> records, Set<Resource> resources) {
	this.basicinfo = basicinfo;
	this.account = account;
	this.relationtype = relationtype;
	this.extendinfo = extendinfo;
	this.records = records;
	this.resources = resources;
}

// Property accessors
@Override
@Id
@GeneratedValue(strategy = IDENTITY)
public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

@OneToOne(fetch = FetchType.EAGER)
public Basicinfo getBasicinfo() {
	return this.basicinfo;
}

public void setBasicinfo(Basicinfo basicinfo) {
	this.basicinfo = basicinfo;
}

@OneToOne(fetch = FetchType.LAZY)
public Account getAccount() {
	return this.account;
}

public void setAccount(Account account) {
	this.account = account;
}

public String getRelationtype() {
	return this.relationtype;
}

public void setRelationtype(String relationtype) {
	this.relationtype = relationtype;
}

public String getExtendinfo() {
	return this.extendinfo;
}

public void setExtendinfo(String extendinfo) {
	this.extendinfo = extendinfo;
}

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
public Set<Record> getRecords() {
	return this.records;
}

public void setRecords(Set<Record> records) {
	this.records = records;
}

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
public Set<Resource> getResources() {
	return this.resources;
}

public void setResources(Set<Resource> resources) {
	this.resources = resources;
}

}