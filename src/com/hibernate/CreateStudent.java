package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class CreateStudent {
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
			Student student= new Student("Paul","Walker","paulwalker@gmail.com");
			//start a transaction
			session.beginTransaction();
			//save the student object
			session.save(student);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
