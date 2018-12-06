package bean.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import inversion.of.control.Coach;

public class BeanLifeCycleApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		//retrieve bean from spring container
		Coach theCoach = context.getBean("coach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
		
	}

}
