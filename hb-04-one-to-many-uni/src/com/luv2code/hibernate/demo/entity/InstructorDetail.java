 package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
//annotate the class as an entity and map to db table
	
//define the fields
	
//annotate the fields with db columns names
	
//create constructors
	
//genenrate getter/setter methods
	
//generate toString90 method	
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;

@Column(name="youtube_channel")
private String youtubeChannel;

@Column(name="hobby")
private String hobby;

//add new field for instructor(also add getter/setter)
//add @OneTOONe annotation
//mappedBy ,it actually refers to the instructorDetail property in Instructor class,so thats how hibernate will figure out how to look up the appropriate instructor for this given  instructorDetail 
//and cascadeType.Alll refers, like if we save the instructorDetail it will save the associated instrucotr
@OneToOne(mappedBy="instructorDetail",
             cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.MERGE})
            		 
private Instructor instructor;



public Instructor getInstructor() {
	return instructor;
}

public void setInstructor(Instructor instructor) {
	this.instructor = instructor;
}

public InstructorDetail() {
}

public InstructorDetail(String youtubeChannel, String hobby) {
	this.youtubeChannel = youtubeChannel;
	this.hobby = hobby;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getYoutubeChannel() {
	return youtubeChannel;
}

public void setYoutubeChannel(String youtubeChannel) {
	this.youtubeChannel = youtubeChannel;
}

public String getHobby() {
	return hobby;
}

public void setHobby(String hobby) {
	this.hobby = hobby;
}

@Override
public String toString() {
	return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
}


}

