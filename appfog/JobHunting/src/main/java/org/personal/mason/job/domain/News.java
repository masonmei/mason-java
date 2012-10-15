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
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "news")
public class News implements java.io.Serializable {

private static final long serialVersionUID = -4217797480915817550L;
// Fields

private Long id;
private Company company;
private String title;
private Timestamp date;
private String content;
private String desc;

// Constructors

/** default constructor */
public News() {
}

/** minimal constructor */
public News(Company company, String title, Timestamp date, String content) {
	this.company = company;
	this.title = title;
	this.date = date;
	this.content = content;
}

/** full constructor */
public News(Company company, String title, Timestamp date, String content,
        String desc) {
	this.company = company;
	this.title = title;
	this.date = date;
	this.content = content;
	this.desc = desc;
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

@Column(name = "title", nullable = false)
public String getTitle() {
	return this.title;
}

public void setTitle(String title) {
	this.title = title;
}

@Column(name = "date", nullable = false, length = 19)
public Timestamp getDate() {
	return this.date;
}

public void setDate(Timestamp date) {
	this.date = date;
}

@Column(name = "content", nullable = false, length = 65535)
public String getContent() {
	return this.content;
}

public void setContent(String content) {
	this.content = content;
}

@Column(name = "desc")
public String getDesc() {
	return this.desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

}