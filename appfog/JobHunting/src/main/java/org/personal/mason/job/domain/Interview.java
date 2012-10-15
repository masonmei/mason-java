package org.personal.mason.job.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Interview entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "interview")
public class Interview implements java.io.Serializable {

/**
 * 
 */
private static final long serialVersionUID = -3826992675412174831L;
// Fields

private Long id;
private String interviewName;
private Timestamp date;
private String location;
private String notes;
private String contactInfo;

// Constructors

/** default constructor */
public Interview() {
}

/** minimal constructor */
public Interview(String interviewName, Timestamp date) {
	this.interviewName = interviewName;
	this.date = date;
}

/** full constructor */
public Interview(String interviewName, Timestamp date, String location,
        String notes, String contactInfo) {
	this.interviewName = interviewName;
	this.date = date;
	this.location = location;
	this.notes = notes;
	this.contactInfo = contactInfo;
}

// Property accessors
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

@Column(name = "date", nullable = false, length = 19)
public Timestamp getDate() {
	return this.date;
}

public void setDate(Timestamp date) {
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