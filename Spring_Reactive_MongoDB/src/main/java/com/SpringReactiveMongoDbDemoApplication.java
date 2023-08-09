package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReactiveMongoDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveMongoDbDemoApplication.class, args);
		System.out.println("Spring Reactive MongoDb running on port No 8585...");
	}
}

		/*
		 *	Dependencies: Spring Reactive Web, Spring Data Reactive MongoDB 
		 * 
		 */
		