package org.personal.mason.job.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Job entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "job")
public class Job implements java.io.Serializable {

private static final long serialVersionUID = -7876411198043833657L;
// Fields

private Long id;
private Company company;
private String jobTitle;
private Timestamp publishDate;
private String requiredTech;
private String content;

// Constructors

/** default constructor */
public Job() {
}

/** minimal constructor */
public Job(Company company, String jobTitle) {
	this.company = company;
	this.jobTitle = jobTitle;
}

/** full constructor */
public Job(Company company, String jobTitle, Timestamp publishDate,
        String requiredTech, String content) {
	this.company = company;
	this.jobTitle = jobTitle;
	this.publishDate = publishDate;
	this.requiredTech = requiredTech;
	this.content = content;
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

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "company_id", nullable = false)
public Company getCompany() {
	return this.company;
}

public void setCompany(Company company) {
	this.company = company;
}

@Column(name = "job_title", nullable = false, length = 100)
public String getJobTitle() {
	return this.jobTitle;
}

public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}

@Column(name = "publish_date", length = 19)
public Timestamp getPublishDate() {
	return this.publishDate;
}

public void setPublishDate(Timestamp publishDate) {
	this.publishDate = publishDate;
}

@Column(name = "required_tech")
public String getRequiredTech() {
	return this.requiredTech;
}

public void setRequiredTech(String requiredTech) {
	this.requiredTech = requiredTech;
}

@Column(name = "content", length = 65535)
public String getContent() {
	return this.content;
}

public void setContent(String content) {
	this.content = content;
}

}