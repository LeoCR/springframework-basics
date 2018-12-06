package inversion.of.control;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		//lets call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		context.close();
	}

}
