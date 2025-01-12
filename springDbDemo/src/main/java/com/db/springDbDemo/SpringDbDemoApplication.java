package com.db.springDbDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SpringDbDemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringDbDemoApplication.class, args);
//		ConfigurationDemo configurationDemo = ((ConfigurationDemo)applicationContext.getBean(ConfigurationDemo.class));
//		System.out.println(configurationDemo.getConfigTestClass().getName());
//
//		ConfigurationDemo configurationDemo1 = ((ConfigurationDemo)applicationContext.getBean(ConfigurationDemo.class));
//		System.out.println(configurationDemo1.getName());

//		Person person = new Person("mohit",1);
//		System.out.println(person);
//        System.out.println(person.getId());
//		System.out.println(person.getName());
//		Optional<Person> person = Optional.ofNullable(new Person("temp",1));
//		if(person.isPresent()){
//			Person currentPerson = person.get();
//		}



	}

//	@Bean
//	public  ConfigTestClass getConfigTestClass(){
//		return new ConfigTestClass("mohit");
//	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("it is running right at server startup");
//	}

//	@Override
//	public void run(String... args) throws Exception {
//		ApplicationContext applicationContext =
//	}
}
