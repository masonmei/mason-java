package org.personal.mason.domain;

// Generated Oct 25, 2012 9:29:03 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Label generated by hbm2java
 */
@Document
public class Label {
@Id
private String id;
@Indexed(unique = true)
private String labelName;

// public Label() {
// }
//
// public Label(String labelName) {
// this.labelName = labelName;
// }

public String getLabelName() {
	return labelName;
}

public void setLabelName(String labelName) {
	this.labelName = labelName;
}

public String getId() {
	return id;
}

}