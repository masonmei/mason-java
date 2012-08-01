package org.personal.mason.pb.server.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "basicInfo")
public class PBBasicInfo implements Serializable {

private static final long serialVersionUID = 2277533067099970756L;
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

@XmlElement(name = "basicinfoId")
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

@XmlElement(name = "name")
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@XmlElement(name = "nickName")
public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

@XmlElement(name = "usedNames")
public String getUsednames() {
	return usednames;
}

public void setUsednames(String usednames) {
	this.usednames = usednames;
}

@XmlElement(name = "cellphones")
public String getCellphones() {
	return cellphones;
}

public void setCellphones(String cellphones) {
	this.cellphones = cellphones;
}

@XmlElement(name = "contacts")
public String getContacts() {
	return contacts;
}

public void setContacts(String contacts) {
	this.contacts = contacts;
}

@XmlElement(name = "phones")
public String getPhones() {
	return phones;
}

public void setPhones(String phones) {
	this.phones = phones;
}

@XmlElement(name = "addresses")
public String getAddresses() {
	return addresses;
}

public void setAddresses(String addresses) {
	this.addresses = addresses;
}

@XmlElement(name = "birth")
public Date getBirth() {
	return birth;
}

public void setBirth(Date birth) {
	this.birth = birth;
}

@XmlElement(name = "nation")
public String getNation() {
	return nation;
}

public void setNation(String nation) {
	this.nation = nation;
}

@XmlElement(name = "favors")
public String getFavors() {
	return favors;
}

public void setFavors(String favors) {
	this.favors = favors;
}

@XmlElement(name = "goodats")
public String getGoodat() {
	return goodat;
}

public void setGoodat(String goodat) {
	this.goodat = goodat;
}

@XmlElement(name = "taboos")
public String getTaboos() {
	return taboos;
}

public void setTaboos(String taboos) {
	this.taboos = taboos;
}

}
