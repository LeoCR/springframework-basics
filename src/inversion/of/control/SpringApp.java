package inversion.of.control;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		//load the spring configuration files
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from  spring container
		Coach theCoach =context.getBean("myCoach",Coach.class);
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		//close the context
		context.close();
	}

}
