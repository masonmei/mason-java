package org.personal.mason.job.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * InterviewMaterial entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "interview_material")
public class InterviewMaterial implements java.io.Serializable {

private static final long serialVersionUID = 3083973005085899153L;

// Fields

private Long id;
private Integer weight;
private String question;
private String answer;
private Timestamp addDate;
private String type;

// Constructors

/** default constructor */
public InterviewMaterial() {
}

/** minimal constructor */
public InterviewMaterial(Integer weight, String question) {
	this.weight = weight;
	this.question = question;
}

/** full constructor */
public InterviewMaterial(Integer weight, String question, String answer,
        Timestamp addDate, String type) {
	this.weight = weight;
	this.question = question;
	this.answer = answer;
	this.addDate = addDate;
	this.type = type;
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

@Column(name = "weight", nullable = false)
public Integer getWeight() {
	return this.weight;
}

public void setWeight(Integer weight) {
	this.weight = weight;
}

@Column(name = "question", nullable = false, length = 1000)
public String getQuestion() {
	return this.question;
}

public void setQuestion(String question) {
	this.question = question;
}

@Column(name = "answer", length = 1000)
public String getAnswer() {
	return this.answer;
}

public void setAnswer(String answer) {
	this.answer = answer;
}

@Column(name = "add_date", length = 19)
public Timestamp getAddDate() {
	return this.addDate;
}

public void setAddDate(Timestamp addDate) {
	this.addDate = addDate;
}

@Column(name = "type", length = 20)
public String getType() {
	return this.type;
}

public void setType(String type) {
	this.type = type;
}

}