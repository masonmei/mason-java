package org.personal.mason.pb.server.api.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "account")
public class PBAccount implements Serializable {

private static final long serialVersionUID = -7306308875574690893L;

private Long id;
private PBRelation relation;
private String account;
private String email;
private String username;
private String secret;
private Timestamp createdate;

@XmlElement(name = "accountId")
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

@XmlElement(name = "profile")
public PBRelation getRelation() {
	return relation;
}

public void setRelation(PBRelation relation) {
	this.relation = relation;
}

@XmlElement(name = "accountName")
public String getAccount() {
	return account;
}

public void setAccount(String account) {
	this.account = account;
}

@XmlElement(name = "email")
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@XmlElement(name = "username")
public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

@XmlElement(name = "secret")
public String getSecret() {
	return secret;
}

public void setSecret(String secret) {
	this.secret = secret;
}

@XmlElement(name = "createDate", required = false)
public Timestamp getCreatedate() {
	return createdate;
}

public void setCreatedate(Timestamp createdate) {
	this.createdate = createdate;
}

@Override
public String toString() {
	return "PBAccount [id=" + id + ", relation=" + relation + ", account=" + account + ", email=" + email + ", username=" + username + ", secret=" + secret
	        + ", createdate=" + createdate + "]";
}

}
