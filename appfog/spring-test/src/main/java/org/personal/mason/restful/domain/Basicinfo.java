package org.personal.mason.restful.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Basicinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@XmlRootElement
public class Basicinfo implements BaseEntity {

// Fields
private static final long serialVersionUID = -9126085378165802257L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String nickname;
private String usednames;
private String cellphones;
private String contacts;
private String phones;
private String addresses;
private Date birth;
private String nation;
private String favors;
private String goodat;
private String taboos;
@OneToOne(fetch = FetchType.LAZY)
private Relation relation;

// Constructors

/** default constructor */
public Basicinfo() {
}

/** minimal constructor */
public Basicinfo(String name) {
	this.name = name;
}

/** full constructor */
public Basicinfo(String name, String nickname, String usednames,
        String cellphones, String contacts, String phones,
        String addresses, Date birth, String nation, String favors,
        String goodat, String taboos) {
	this.name = name;
	this.nickname = nickname;
	this.usednames = usednames;
	this.cellphones = cellphones;
	this.contacts = contacts;
	this.phones = phones;
	this.addresses = addresses;
	this.birth = birth;
	this.nation = nation;
	this.favors = favors;
	this.goodat = goodat;
	this.taboos = taboos;
}

// Property accessors

public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

@Column(length = 80)
public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}

@Column(length = 160)
public String getNickname() {
	return this.nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

@Column(length = 160)
public String getUsednames() {
	return this.usednames;
}

public void setUsednames(String usednames) {
	this.usednames = usednames;
}

@Column(length = 240)
public String getCellphones() {
	return this.cellphones;
}

public void setCellphones(String cellphones) {
	this.cellphones = cellphones;
}

@Column(length=240)
public String getContacts() {
	return this.contacts;
}

public void setContacts(String contacts) {
	this.contacts = contacts;
}

@Column(length=240)
public String getPhones() {
	return this.phones;
}

public void setPhones(String phones) {
	this.phones = phones;
}

@Column(columnDefinition="text")
public String getAddresses() {
	return this.addresses;
}

public void setAddresses(String addresses) {
	this.addresses = addresses;
}

@Temporal(TemporalType.DATE)
public Date getBirth() {
	return this.birth;
}

public void setBirth(Date birth) {
	this.birth = birth;
}

@Column(length=80)
public String getNation() {
	return this.nation;
}

public void setNation(String nation) {
	this.nation = nation;
}
@Column(length=1000)
public String getFavors() {
	return this.favors;
}

public void setFavors(String favors) {
	this.favors = favors;
}

@Column(length=1000)
public String getGoodat() {
	return this.goodat;
}

public void setGoodat(String goodat) {
	this.goodat = goodat;
}

@Column(length=1000)
public String getTaboos() {
	return this.taboos;
}

public void setTaboos(String taboos) {
	this.taboos = taboos;
}

public Relation getRelation() {
	return relation;
}

public void setRelation(Relation relation) {
	this.relation = relation;
}
}