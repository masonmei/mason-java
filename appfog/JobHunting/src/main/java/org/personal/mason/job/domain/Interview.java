package org.personal.mason.job.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Interview generated by hbm2java
 */
@Entity
@Table(name = "interview")
public class Interview implements java.io.Serializable {
private static final long serialVersionUID = -9134115913682003322L;
private Long id;
private String interviewName;
private Date date;
private String location;
private String notes;
private String contactInfo;

public Interview() {
}

public Interview(String interviewName, Date date) {
	this.interviewName = interviewName;
	this.date = date;
}

public Interview(String interviewName, Date date, String location, String notes, String contactInfo) {
	this.interviewName = interviewName;
	this.date = date;
	this.location = location;
	this.notes = notes;
	this.contactInfo = contactInfo;
}

@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name = "id", unique = true, nullable = false)
public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

@Column(name = "interview_name", nullable = false, length = 100)
public String getInterviewName() {
	return this.interviewName;
}

public void setInterviewName(String interviewName) {
	this.interviewName = interviewName;
}

@Temporal(TemporalType.TIMESTAMP)
@Column(name = "date", nullable = false, length = 19)
public Date getDate() {
	return this.date;
}

public void setDate(Date date) {
	this.date = date;
}

@Column(name = "location", length = 500)
public String getLocation() {
	return this.location;
}

public void setLocation(String location) {
	this.location = location;
}

@Column(name = "notes", length = 1000)
public String getNotes() {
	return this.notes;
}

public void setNotes(String notes) {
	this.notes = notes;
}

@Column(name = "contact_info", length = 1000)
public String getContactInfo() {
	return this.contactInfo;
}

public void setContactInfo(String contactInfo) {
	this.contactInfo = contactInfo;
}

}
