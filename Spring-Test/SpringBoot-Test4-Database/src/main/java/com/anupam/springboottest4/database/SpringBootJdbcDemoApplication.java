package com.anupam.springboottest4.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anupam.springboottest4.database.entity.Person;
import com.anupam.springboottest4.database.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringBootJdbcDemoApplication implements CommandLineRunner{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJdbcDao personJdbcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("All persons using Custom Row Mapper : {}", 
				personJdbcDao.retrieveAllUsingCustomRowMapper());
		
		logger.info("All persons : {}", personJdbcDao.retrieveAll());
		
		logger.info("Person with Specific id : {}", personJdbcDao.retrieveById(10001));
		
		logger.info("Deleting Person. Rows affected is {}", personJdbcDao.deleteById(10002));
		
		logger.info("Insert new person {}", 
				personJdbcDao.insert(new Person(10004, "Tara", "Berlin", new Date())));
		
		logger.info("Update person {}", 
				personJdbcDao.update(new Person(10003, "Pieter", "Utrecht", new Date())));
	}

}
