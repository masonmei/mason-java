package org.personal.mason.ws.client.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "country", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name") })
public class Country implements Serializable {

// Fields

private static final long serialVersionUID = 6713930970706941265L;
private Long id;
private String name;
private String phoneCode;
private String isoCode;
private String currencyISOCode;
private byte[] countryFlag;
private String capitalCity;
private Continent continent;

private Set<Language> languages = new HashSet<Language>(0);

// Constructors

/** default constructor */
public Country() {
}

/** minimal constructor */
public Country(String name, String phoneCode) {
	this.name = name;
	this.phoneCode = phoneCode;
}

/** full constructor */
public Country(String name, String phoneCode, String isoCode, String currencyISOCode, byte[] countryFlag, String capitalCity, Continent continent, Set<Language> languages) {
	this.name = name;
	this.phoneCode = phoneCode;
	this.isoCode = isoCode;
	this.currencyISOCode = currencyISOCode;
	this.countryFlag = countryFlag;
	this.capitalCity = capitalCity;
	this.continent = continent;
	this.languages = languages;
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

@Column(name = "phone_code", unique = false, length = 10)
public String getPhoneCode() {
	return this.phoneCode;
}

public void setPhoneCode(String phoneCode) {
	this.phoneCode = phoneCode;
}

@Column(name = "iso_code", length = 10)
public String getIsoCode() {
	return this.isoCode;
}

public void setIsoCode(String isoCode) {
	this.isoCode = isoCode;
}

@Column(name = "currency_iso_code", length = 10)
public String getCurrencyIsoCode() {
	return this.currencyISOCode;
}

public void setCurrencyIsoCode(String currencyIsoCode) {
	this.currencyISOCode = currencyIsoCode;
}

@Lob
@Basic(fetch = FetchType.LAZY)
@Column(name = "country_flag", length = 65535)
public byte[] getCountryFlag() {
	return this.countryFlag;
}

public void setCountryFlag(byte[] countryFlag) {
	this.countryFlag = countryFlag;
}

@Column(name = "capitalCity", length = 100)
public String getCapitalCity() {
	return capitalCity;
}

public void setCapitalCity(String capitalCity) {
	this.capitalCity = capitalCity;
}

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "continentId", nullable = false)
public Continent getContinent() {
	return this.continent;
}

public void setContinent(Continent continent) {
	this.continent = continent;
}

@ManyToMany
public Set<Language> getLanguages() {
	return languages;
}

public void setLanguages(Set<Language> contries) {
	this.languages = contries;
}

@Override
public String toString() {
	return "Country [id=" + id + ", name=" + name + ", phoneCode=" + phoneCode + ", isoCode=" + isoCode + ", currencyISOCode=" + currencyISOCode
	        + ", countryFlag=" + Arrays.toString(countryFlag) + ", capitalCity=" + capitalCity + ", continent=" + continent + ", languages=" + languages + "]";
}


}
