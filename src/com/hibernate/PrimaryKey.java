package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class PrimaryKey {

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
			//create 3 students objects
			Student student1= new Student("John","Doe","john@gmail.com");
			Student student2= new Student("Mary","Walker","marywalker@gmail.com");
			Student student3= new Student("Sonia","Walker","soniawalker@gmail.com");
			//start a transaction
			session.beginTransaction();
			//save the student object
			session.save(student1);
			session.save(student2);
			session.save(student3);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
					e.getStackTrace();
				}
		}

}
