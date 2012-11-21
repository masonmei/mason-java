package org.personal.mason.domain.pb;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Resources entity. @author MyEclipse Persistence Tools
 */

@Document
@XmlRootElement
public class Resource {

@Id
private String id;
private String resourcename;
private Date builddate;
private String description;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getResourcename() {
	return resourcename;
}

public void setResourcename(String resourcename) {
	this.resourcename = resourcename;
}

public Date getBuilddate() {
	return builddate;
}

public void setBuilddate(Date builddate) {
	this.builddate = builddate;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

}