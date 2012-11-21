package org.personal.mason.domain.pb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Relation entity. @author MyEclipse Persistence Tools
 */

@Document
@XmlRootElement
public class Relation {

@Id
private String id;

private Basicinfo basicinfo;
private String relationtype;
private String extendinfo;
@DBRef
private List<Record> records = new ArrayList<Record>();
@DBRef
private List<Resource> resources = new ArrayList<Resource>();

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public Basicinfo getBasicinfo() {
	return basicinfo;
}

public void setBasicinfo(Basicinfo basicinfo) {
	this.basicinfo = basicinfo;
}

public String getRelationtype() {
	return relationtype;
}

public void setRelationtype(String relationtype) {
	this.relationtype = relationtype;
}

public String getExtendinfo() {
	return extendinfo;
}

public void setExtendinfo(String extendinfo) {
	this.extendinfo = extendinfo;
}

public List<Record> getRecords() {
	return records;
}

public void setRecords(List<Record> records) {
	this.records = records;
}

public List<Resource> getResources() {
	return resources;
}

public void setResources(List<Resource> resources) {
	this.resources = resources;
}

}