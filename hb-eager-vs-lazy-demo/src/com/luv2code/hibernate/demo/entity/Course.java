package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

//define our fields
	
//define constructor
	
//define getter setters
	
//define toString
	
//define fields

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id")
private int id;

private String title;

//instructor_id is a column in the course table that has the key that points back to Instructor
@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.DETACH})
@JoinColumn(name="instructor_id")
private Instructor instructor;

public Course() {
}

public Course(String title) {
	super();
	this.title = title;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Instructor getInstructor() {
	return instructor;
}

public void setInstructor(Instructor instructor) {
	this.instructor = instructor;
}

@Override
public String toString() {
	return "Course [id=" + id + ", title=" + title + "]";
}

}

	
