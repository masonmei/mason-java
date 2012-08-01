package org.personal.mason.pb.server.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Resources entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Resource implements BaseEntity {

private static final long serialVersionUID = 7280829499314917780L;
private Long id;
private String resourcename;
private Date builddate;
private String description;

// Constructors

/** default constructor */
public Resource() {
}

/** minimal constructor */
public Resource(String resourcename) {
	this.resourcename = resourcename;
}

/** full constructor */
public Resource(String resourcename, Date builddate,
        String description) {
	this.resourcename = resourcename;
	this.builddate = builddate;
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

public String getResourcename() {
	return this.resourcename;
}

public void setResourcename(String resourcename) {
	this.resourcename = resourcename;
}

@Temporal(TemporalType.DATE)
public Date getBuilddate() {
	return this.builddate;
}

public void setBuilddate(Date builddate) {
	this.builddate = builddate;
}

public String getDescription() {
	return this.description;
}

public void setDescription(String description) {
	this.description = description;
}

}