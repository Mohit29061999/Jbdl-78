package com.jbdl.LibraryManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);

		//orignal problem was creation of BuilderDemo object was tricky
		//we have to remember order of 10-15 objects
//		BuilderDemo demo = new BuilderDemo.BuilderClass().setCity("blr").setId("1").setName("mohit")
//				.build();
//
//		//BuilderDemo demo = new BuilderDemo("1","mohit","blr","560048","s-14");
//		System.out.println(demo.getCity());
//		System.out.println(demo.getId());
//		System.out.println(demo.getName());

	}

}
