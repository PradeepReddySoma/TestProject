package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
	               .configure("hibernate.cfg.xml")
	               .addAnnotatedClass(Student.class)
	               .buildSessionFactory();
Session session=factory.getCurrentSession();
try { 
System.out.println("CRETATING A NEW STUDENT OBJECT");
Student tempStudent1=new Student("birti","Doe","paul%luv2code.com");
Student tempStudent2=new Student("villan","perk","villan%luv2code.com");
Student tempStudent3=new Student("john","buchik","john%luv2code.com");

session.beginTransaction();

System.out.println("saving 3 student objects");
session.save(tempStudent1);
session.save(tempStudent2);
session.save(tempStudent3);

session.getTransaction().commit();
System.out.println("done");
}
finally {
factory.close();
}


	}

}
