package org.personal.mason.pb.server.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Record")
public class PBRecord implements Serializable {

private static final long serialVersionUID = -8342138865578247446L;

private Long id;
private String type;
private Date startdate;
private Date enddate;
private String accomplishment;
private String description;

@XmlElement(name = "recordId")
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

@XmlElement(name = "type")
public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

@XmlElement(name="startDate")
public Date getStartdate() {
	return startdate;
}

public void setStartdate(Date startdate) {
	this.startdate = startdate;
}

@XmlElement(name="endDate")
public Date getEnddate() {
	return enddate;
}

public void setEnddate(Date enddate) {
	this.enddate = enddate;
}

@XmlElement(name="accomplishment")
public String getAccomplishment() {
	return accomplishment;
}

public void setAccomplishment(String accomplishment) {
	this.accomplishment = accomplishment;
}

@XmlElement(name="desc")
public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

}
