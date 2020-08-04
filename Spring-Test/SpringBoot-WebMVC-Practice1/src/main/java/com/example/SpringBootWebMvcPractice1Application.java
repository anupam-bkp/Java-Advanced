package com.example;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootWebMvcPractice1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebMvcPractice1Application.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				System.out.println("Let's inspect the beans provided by Spring Boot!");
				final String[] beanNames = ctx.getBeanDefinitionNames();
				Arrays.sort(beanNames);
				for(String beanName: beanNames) {
					System.out.println(beanName);
				}
			}
		};	
	}*/

}
