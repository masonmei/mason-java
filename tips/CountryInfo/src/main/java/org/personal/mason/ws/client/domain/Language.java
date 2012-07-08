package org.personal.mason.ws.client.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "language", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name") })
public class Language implements Serializable {

private static final long serialVersionUID = -3769551387587544477L;
private Long id;
private String name;
private String languageCode;

private Set<Country> contries = new HashSet<Country>(0);

// Constructors

/** default constructor */
public Language() {
}

/** minimal constructor */
public Language(String name) {
	this.name = name;
}

/** full constructor */
public Language(String name, String langCode, Set<Country> contries) {
	super();
	this.name = name;
	this.languageCode = langCode;
	this.contries = contries;
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

@Column(name = "language_code", unique = false, length = 10)
public String getLanguageCode() {
	return this.languageCode;
}

public void setLanguageCode(String langCode) {
	this.languageCode = langCode;
}

@ManyToMany(fetch = FetchType.LAZY, mappedBy="languages")
public Set<Country> getContries() {
	return contries;
}

public void setContries(Set<Country> contries) {
	this.contries = contries;
}

}
