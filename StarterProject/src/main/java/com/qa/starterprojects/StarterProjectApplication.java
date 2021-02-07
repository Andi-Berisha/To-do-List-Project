package com.qa.starterprojects;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class StarterProjectApplication {

	public static void main(String[] args) {
		ApplicationContext beanBag = SpringApplication.run(StarterProjectApplication.class, args);
		
		System.out.println(beanBag.getBean("greeting", String.class));
	    System.out.println(beanBag.getBean("time",String.class));
	    System.out.println(beanBag.getBean("farewell",String.class));
	}
	
	
	
	@Bean
	public String farewell(){
		return "ciao amigo";
	}

}
