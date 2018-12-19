package com.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class FetchJoinApp {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create a session
		Session session=factory.getCurrentSession();
		try {
			//start a transaction
			session.beginTransaction();
			//get the instructor from db
			int theId=1;
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
									+ "JOIN FETCH i.courses "
									+ "where i.id=:theInstructorId", 
							Instructor.class);
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			// execute query and get instructor
			Instructor tempInstructor=query.getSingleResult();
			System.out.println("-Instructor: "+tempInstructor);
			session.getTransaction().commit();
			session.close();
			System.out.println("\nThe session is now closed!\n");
			System.out.println("-Courses: "+tempInstructor.getCourses());
			//commit transaction
			System.out.println("Done!");
		} 
		catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
