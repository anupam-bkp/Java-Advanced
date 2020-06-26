package com.example.dbtest.dataJpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseTestDataJpaApplication implements CommandLineRunner{

	@Autowired
	InstructorService instructorService;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseTestDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		final List<Instructor> allInstructors = instructorService.findAllInstructors();
		
		System.out.println("=========================");
		System.out.println(allInstructors);
		System.out.println("=========================");
	}

}
