package org.personal.mason.job.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Offer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "offer")
public class Offer implements java.io.Serializable {

private static final long serialVersionUID = 7715792686464399424L;
// Fields

private Long id;
private String offerName;
private Date receivedDate;
private Date workDate;
private Integer salary;
private String salaryDescription;
private String company;
private String workplace;
private String note;

// Constructors

/** default constructor */
public Offer() {
}

/** minimal constructor */
public Offer(Long id, String offerName, Date receivedDate, Integer salary,
        String company, String workplace) {
	this.id = id;
	this.offerName = offerName;
	this.receivedDate = receivedDate;
	this.salary = salary;
	this.company = company;
	this.workplace = workplace;
}

/** full constructor */
public Offer(Long id, String offerName, Date receivedDate, Date workDate,
        Integer salary, String salaryDescription, String company,
        String workplace, String note) {
	this.id = id;
	this.offerName = offerName;
	this.receivedDate = receivedDate;
	this.workDate = workDate;
	this.salary = salary;
	this.salaryDescription = salaryDescription;
	this.company = company;
	this.workplace = workplace;
	this.note = note;
}

// Property accessors
@Id
@Column(name = "id", unique = true, nullable = false)
public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

@Column(name = "offer_name", nullable = false, length = 100)
public String getOfferName() {
	return this.offerName;
}

public void setOfferName(String offerName) {
	this.offerName = offerName;
}

@Temporal(TemporalType.DATE)
@Column(name = "received_date", nullable = false, length = 10)
public Date getReceivedDate() {
	return this.receivedDate;
}

public void setReceivedDate(Date receivedDate) {
	this.receivedDate = receivedDate;
}

@Temporal(TemporalType.DATE)
@Column(name = "work_date", length = 10)
public Date getWorkDate() {
	return this.workDate;
}

public void setWorkDate(Date workDate) {
	this.workDate = workDate;
}

@Column(name = "salary", nullable = false)
public Integer getSalary() {
	return this.salary;
}

public void setSalary(Integer salary) {
	this.salary = salary;
}

@Column(name = "salary_description", length = 65535)
public String getSalaryDescription() {
	return this.salaryDescription;
}

public void setSalaryDescription(String salaryDescription) {
	this.salaryDescription = salaryDescription;
}

@Column(name = "company", nullable = false)
public String getCompany() {
	return this.company;
}

public void setCompany(String company) {
	this.company = company;
}

@Column(name = "workplace", nullable = false)
public String getWorkplace() {
	return this.workplace;
}

public void setWorkplace(String workplace) {
	this.workplace = workplace;
}

@Column(name = "note", length = 1000)
public String getNote() {
	return this.note;
}

public void setNote(String note) {
	this.note = note;
}

}