package org.personal.mason.restful.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Relation entity. @author MyEclipse Persistence Tools
 */
@Entity
@XmlRootElement
public class Relation implements BaseEntity {

// Fields

private static final long serialVersionUID = 7115261964893523750L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@OneToOne(fetch = FetchType.EAGER, mappedBy = "relation")
private Basicinfo basicinfo;
@ManyToOne(fetch = FetchType.LAZY)
private Account account;
private String relationtype;
private String extendinfo;
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private Set<Record> records = new HashSet<Record>(0);
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

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

public Set<Record> getRecords() {
	return this.records;
}

public void setRecords(Set<Record> records) {
	this.records = records;
}

public Set<Resource> getResources() {
	return this.resources;
}

public void setResources(Set<Resource> resources) {
	this.resources = resources;
}

}