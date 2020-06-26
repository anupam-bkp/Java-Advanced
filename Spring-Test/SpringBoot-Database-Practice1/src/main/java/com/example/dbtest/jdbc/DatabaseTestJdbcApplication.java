package com.example.dbtest.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dbtest.jdbc.Instructor;
import com.example.dbtest.jdbc.InstructorJdbcDao;

@SpringBootApplication
public class DatabaseTestJdbcApplication implements CommandLineRunner{

	@Autowired
	private InstructorJdbcDao instructorJdbcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseTestJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final Instructor instructor = instructorJdbcDao.retrieveById();
		System.out.println(instructor);
	}
}
