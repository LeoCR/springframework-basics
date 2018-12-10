package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class UpdateStudent {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create a session
		Session session=factory.getCurrentSession();
		try {
			int studentId=1;
			
			//now get a new session and start a transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id : primary key
			System.out.println("\nGetting student with id: "+studentId);
			Student oldStudent = session.get(Student.class, studentId);
			System.out.println("Update Student... complete ");
			oldStudent.setFirstName("Scooby");
			//commit the transaction
			session.getTransaction().commit();
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			//update email for all students
			System.out.println("Update email for all Student");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
