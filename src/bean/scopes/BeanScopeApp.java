package bean.scopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import inversion.of.control.Coach;

public class BeanScopeApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		//retrieve bean from spring container
		Coach theCoach = context.getBean("coach",Coach.class);
		Coach alphaCoach = context.getBean("coach",Coach.class);
		boolean result=(theCoach==alphaCoach);
		System.out.println("\n Pointing to the same Object "+result);
		System.out.println("\nMemory location for theCoach "+theCoach);
		System.out.println("\nMemory location for alphaCoach "+alphaCoach);
		context.close();
		
	}

}
