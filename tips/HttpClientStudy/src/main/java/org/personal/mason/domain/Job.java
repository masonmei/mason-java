package org.personal.mason.domain;

import java.util.Date;

/**
 * Job generated by hbm2java
 */
public class Job {
private String id;
private String jobTitle;
private Date publishDate;
private String requiredTech;
private String content;

public String getJobTitle() {
	return jobTitle;
}

public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}

public Date getPublishDate() {
	return publishDate;
}

public void setPublishDate(Date publishDate) {
	this.publishDate = publishDate;
}

public String getRequiredTech() {
	return requiredTech;
}

public void setRequiredTech(String requiredTech) {
	this.requiredTech = requiredTech;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getId() {
	return id;
}

public void setId(String id) {
	if (id.isEmpty()) {
		this.id = null;
	} else {
		this.id = id;
	}
}

}
