package org.personal.mason.domain.pb;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Records entity. @author MyEclipse Persistence Tools
 */

@Document
@XmlRootElement
public class Record {

@Id
private String id;
private String type;
private Date startdate;
private Date enddate;
private String accomplishment;
private String description;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Date getStartdate() {
	return startdate;
}

public void setStartdate(Date startdate) {
	this.startdate = startdate;
}

public Date getEnddate() {
	return enddate;
}

public void setEnddate(Date enddate) {
	this.enddate = enddate;
}

public String getAccomplishment() {
	return accomplishment;
}

public void setAccomplishment(String accomplishment) {
	this.accomplishment = accomplishment;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

}