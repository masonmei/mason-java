package org.personal.mason.pb.server.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Relation")
public class PBRelation implements Serializable {

private static final long serialVersionUID = 1652270659055910824L;

private Long id;
private PBBasicInfo basicinfo;
private String relationtype;
private String extendinfo;
private Set<PBRecord> records = new HashSet<PBRecord>(0);
private Set<PBResource> resources = new HashSet<PBResource>(0);

@XmlElement(name="relationId")
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

@XmlElement(name="basicinfo")
public PBBasicInfo getBasicinfo() {
	return basicinfo;
}

public void setBasicinfo(PBBasicInfo basicinfo) {
	this.basicinfo = basicinfo;
}

@XmlElement(name="relationType")
public String getRelationtype() {
	return relationtype;
}

public void setRelationtype(String relationtype) {
	this.relationtype = relationtype;
}

@XmlElement(name="extendinfo")
public String getExtendinfo() {
	return extendinfo;
}

public void setExtendinfo(String extendinfo) {
	this.extendinfo = extendinfo;
}

@XmlElement(name="records")
public Set<PBRecord> getRecords() {
	return records;
}

@XmlElement(name="resources")
public Set<PBResource> getResources() {
	return resources;
}

}
