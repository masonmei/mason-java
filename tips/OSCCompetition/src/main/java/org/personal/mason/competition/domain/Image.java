package org.personal.mason.competition.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Image {

@Id
private String id;

private Date lastUpdate;
private String fileName;
private byte[] imageData;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public Date getLastUpdate() {
	return lastUpdate;
}

public void setLastUpdate(Date lastUpdate) {
	this.lastUpdate = lastUpdate;
}

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public byte[] getImageData() {
	return imageData;
}

public void setImageData(byte[] imageData) {
	this.imageData = imageData;
}

}
