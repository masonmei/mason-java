package org.personal.mason.pb.server.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resource")
public class PBResource implements Serializable {

private static final long serialVersionUID = 6063071513678734008L;

private Long id;
private String resourcename;
private Date builddate;
private String description;

@XmlElement(name="resourceId")
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

@XmlElement(name="resourceName")
public String getResourcename() {
	return resourcename;
}

public void setResourcename(String resourcename) {
	this.resourcename = resourcename;
}

@XmlElement(name="buildDate")
public Date getBuilddate() {
	return builddate;
}

public void setBuilddate(Date builddate) {
	this.builddate = builddate;
}

@XmlElement(name="desc")
public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

}
