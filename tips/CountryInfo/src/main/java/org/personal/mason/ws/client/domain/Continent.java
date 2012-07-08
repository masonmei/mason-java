package org.personal.mason.ws.client.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "continent", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name") })
public class Continent implements Serializable {

// Fields

private static final long serialVersionUID = 2001767095203421272L;
private Long id;
private String name;
private String continentCode;

private Set<Country> contries = new HashSet<Country>(0);

// Constructors

/** default constructor */
public Continent() {
}

/** minimal constructor */
public Continent(String name) {
	this.name = name;
}

/** full constructor */
public Continent(String name, String continentCode, Set<Country> countries) {
	super();
	this.name = name;
	this.continentCode = continentCode;
	this.contries = countries;
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

@Column(name = "name", unique = true, nullable = false, length = 64)
public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}

@Column(name = "continent_code", unique = false, length = 10)
public String getContinentCode() {
	return this.continentCode;
}

public void setContinentCode(String continentCode) {
	this.continentCode = continentCode;
}
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "continent")
public Set<Country> getContries() {
	return contries;
}

public void setContries(Set<Country> contries) {
	this.contries = contries;
}

}
