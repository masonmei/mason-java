package org.personal.mason.job.domain;

// Generated Oct 25, 2012 9:29:03 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Label generated by hbm2java
 */
@Entity
@Table(name = "label")
public class Label implements java.io.Serializable {
private static final long serialVersionUID = -5379590302180459359L;
private long id;
private String labelName;
private String desc;
private Set<CompanyLabel> companyLabels = new HashSet<CompanyLabel>(0);

public Label() {
}

public Label(long id, String labelName) {
	this.id = id;
	this.labelName = labelName;
}

public Label(long id, String labelName, String desc, Set<CompanyLabel> companyLabels) {
	this.id = id;
	this.labelName = labelName;
	this.desc = desc;
	this.companyLabels = companyLabels;
}

@Id
@Column(name = "id", unique = true, nullable = false)
public long getId() {
	return this.id;
}

public void setId(long id) {
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

@OneToMany(fetch = FetchType.LAZY, mappedBy = "label")
public Set<CompanyLabel> getCompanyLabels() {
	return this.companyLabels;
}

public void setCompanyLabels(Set<CompanyLabel> companyLabels) {
	this.companyLabels = companyLabels;
}

}
