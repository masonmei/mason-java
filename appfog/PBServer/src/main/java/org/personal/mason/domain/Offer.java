package org.personal.mason.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Offer generated by hbm2java
 */
@Document
public class Offer {
@Id
private String id;
private String offerName;
private Date receivedDate;
private Date workDate;
private int salary;
private String salaryDescription;
private String company;
private String workplace;
private String note;

public String getOfferName() {
	return offerName;
}

public void setOfferName(String offerName) {
	this.offerName = offerName;
}

public Date getReceivedDate() {
	return receivedDate;
}

public void setReceivedDate(Date receivedDate) {
	this.receivedDate = receivedDate;
}

public Date getWorkDate() {
	return workDate;
}

public void setWorkDate(Date workDate) {
	this.workDate = workDate;
}

public int getSalary() {
	return salary;
}

public void setSalary(int salary) {
	this.salary = salary;
}

public String getSalaryDescription() {
	return salaryDescription;
}

public void setSalaryDescription(String salaryDescription) {
	this.salaryDescription = salaryDescription;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public String getWorkplace() {
	return workplace;
}

public void setWorkplace(String workplace) {
	this.workplace = workplace;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}

public String getId() {
	return id;
}

}
