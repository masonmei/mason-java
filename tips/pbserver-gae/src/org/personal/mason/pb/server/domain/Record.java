package org.personal.mason.pb.server.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Records entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Record implements BaseEntity {

private static final long serialVersionUID = -2600644981581057766L;
// Fields

private Long id;
private String type;
private Date startdate;
private Date enddate;
private String accomplishment;
private String description;

// Constructors

/** default constructor */
public Record() {
}

/** minimal constructor */
public Record(String type, Date startdate) {
	this.type = type;
	this.startdate = startdate;
}

/** full constructor */
public Record(String type, Date startdate, Date enddate,
        String accomplishment, String description) {
	this.type = type;
	this.startdate = startdate;
	this.enddate = enddate;
	this.accomplishment = accomplishment;
	this.description = description;
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

public String getAccomplishment() {
	return this.accomplishment;
}

public void setAccomplishment(String accomplishment) {
	this.accomplishment = accomplishment;
}

public String getDescription() {
	return this.description;
}

public void setDescription(String description) {
	this.description = description;
}

@Temporal(TemporalType.DATE)
public Date getEnddate() {
	return this.enddate;
}

public void setEnddate(Date enddate) {
	this.enddate = enddate;
}

@Temporal(TemporalType.DATE)
public Date getStartdate() {
	return this.startdate;
}

public void setStartdate(Date startdate) {
	this.startdate = startdate;
}

public String getType() {
	return this.type;
}

public void setType(String type) {
	this.type = type;
}

}