package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo4 {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
		   Session session=factory.getCurrentSession();
		  try { 
			 	   
		   session.beginTransaction();
		   //for deleting
		   int id=6;
		   System.out.println("deleting a record of id=6");
		   List<Student> studentlist1=session.createQuery("from Student").list();
		   System.out.println(studentlist1);//1
		   Student oneStudent=session.get(Student.class,id);
		   session.delete(oneStudent);  //2
		   //1, 2 will show the actual deleted records and cannot be printed differently after delete 
		  
		//   session.createQuery("delete from Student where id=3").executeUpdate(); 
		   System.out.println(studentlist1);//prints records after deleted
		   session.getTransaction().commit(); 
		   System.out.println("done...!!");
		}
		  finally {
			  factory.close();
		  }
	}

}
