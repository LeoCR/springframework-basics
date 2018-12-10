package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class ReadStudent {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create a session
		Session session=factory.getCurrentSession();
		try {
			//use the sesion object to save Java Object
			System.out.println("Creating a new Student Object");
			//create a student object
			//Student student= new Student("Daffi","Duck","daffy@gmail.com");
			//start a transaction
			session.beginTransaction();
			//save the student object
			System.out.println("Saving the Student");
			//System.out.println(student);
			//session.save(student);
			//commit transaction
			session.getTransaction().commit();
			//find out the student's id: primary key
			System.out.println("Saved student.Generated id: "+1);
			
			//now get a new session and start a transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id : primary key
			System.out.println("\nGetting student with id: "+1);
			Student newStudent = session.get(Student.class, 1);
			System.out.println("Get complete: "+newStudent);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
