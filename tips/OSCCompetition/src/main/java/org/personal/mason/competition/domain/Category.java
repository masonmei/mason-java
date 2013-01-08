package org.personal.mason.competition.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category {

@Id
private String id;

private String categoryName;
private boolean publicPrivilege;

@DBRef
private Account account;

@DBRef
private List<Image> images = new ArrayList<Image>();

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

public String getCategoryName() {
	return categoryName;
}

public boolean isPublicPrivilege() {
	return publicPrivilege;
}

public void setPublicPrivilege(boolean publicPrivilege) {
	this.publicPrivilege = publicPrivilege;
}

public void setAccount(Account account) {
	this.account = account;
}

public Account getAccount() {
	return account;
}

public List<Image> getImages() {
	return images;
}

public void setImages(List<Image> images) {
	this.images = images;
}

}
