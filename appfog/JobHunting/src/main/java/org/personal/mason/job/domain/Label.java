package org.personal.mason.job.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Label entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "label")
public class Label implements java.io.Serializable {

private static final long serialVersionUID = -4438987000038612085L;
// Fields

private Long id;
private String labelName;
private String desc;
private Set<CompanyLabel> companyLabels = new HashSet<CompanyLabel>(0);

// Constructors

/** default constructor */
public Label() {
}

/** minimal constructor */
public Label(Long id, String labelName) {
	this.id = id;
	this.labelName = labelName;
}

/** full constructor */
public Label(Long id, String labelName, String desc,
        Set<CompanyLabel> companyLabels) {
	this.id = id;
	this.labelName = labelName;
	this.desc = desc;
	this.companyLabels = companyLabels;
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

@Column(name = "label_name", nullable = false, length = 50)
public String getLabelName() {
	return this.labelName;
}

public void setLabelName(String labelName) {
	this.labelName = labelName;
}

@Column(name = "desc")
public String getDesc() {
	return this.desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "label")
public Set<CompanyLabel> getCompanyLabels() {
	return this.companyLabels;
}

public void setCompanyLabels(Set<CompanyLabel> companyLabels) {
	this.companyLabels = companyLabels;
}

}