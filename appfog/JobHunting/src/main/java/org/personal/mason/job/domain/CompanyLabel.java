package org.personal.mason.job.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CompanyLabel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "company_label")
public class CompanyLabel implements java.io.Serializable {

private static final long serialVersionUID = 197685935842687457L;
// Fields

private Long id;
private Label label;
private Company company;

// Constructors

/** default constructor */
public CompanyLabel() {
}

/** full constructor */
public CompanyLabel(Long id, Label label, Company company) {
	this.id = id;
	this.label = label;
	this.company = company;
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

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "label_id", nullable = false)
public Label getLabel() {
	return this.label;
}

public void setLabel(Label label) {
	this.label = label;
}

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "company_id", nullable = false)
public Company getCompany() {
	return this.company;
}

public void setCompany(Company company) {
	this.company = company;
}

}