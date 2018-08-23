 package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Instructor.class)
				               .addAnnotatedClass(InstructorDetail.class)
				               .addAnnotatedClass(Course.class) 
				               .addAnnotatedClass(Review.class)
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
		   Session session=factory.getCurrentSession();
		  
		  try { 
			 	 
			  //start a transaction
			  session.beginTransaction();
		     
			  //get the student mary from database
			  int studentId=2;
			  Student tempStudent=session.get(Student.class, studentId);
			  
			  System.out.println("\nloaded student: "+tempStudent);
			  System.out.println("Courses: "+tempStudent.getCourses());
			  
			  //create more courses
			  Course tempCourse1=new Course("Rubiks Coube - How To speed Cube");
			  Course tempCourse2=new Course("Atari 2600 - Game Development");
			  
			  //add student to the courses(considering  a group to which student is to be added for the course)
			  tempCourse1.addStudent(tempStudent);
			  tempCourse2.addStudent(tempStudent);
			  
			  //save the courses
			  System.out.println("\nsaving the courses");
			  session.save(tempCourse2);
			  session.save(tempCourse1);
			  
			  //commit transaction 
		    session.getTransaction().commit();
		    System.out.println("done");
		  }
		  finally {
			  session.close();
			  factory.close();
		  }
		
	}

}
