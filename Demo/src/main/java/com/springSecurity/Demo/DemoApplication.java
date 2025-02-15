package com.springSecurity.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private  MyUserRepo myUserRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		//here write code to save users to myUser table
		System.out.println("run method");




//		myUserRepo.save(MyUser.builder().username("developer").password("$2a$10$NT.BLtTzDxgCZkEaPqk4nuVIAIGIAiRHC.F9OdlF0f8u3nXSnJbpO")
//				.accountExpired(false).accountNonLocked(false).
//				authorities("DEVELOPER,TESTER").build());
////     myUserRepo.save(MyUser.builder().username("developer").password("developer")
////           .accountExpired(false).accountNonLocked(false).
////           authorities("DEVELOPER,TESTER").build());
//		myUserRepo.save(MyUser.builder().username("admin").password("$2a$10$/i7NCzUP7IIoxLFC40iehe9D7chexxZzMpVu31gZM4WQrkaHuk2Qm")
//				.accountExpired(false).accountNonLocked(false).
//				authorities("ADMIN").build());
	}
}
