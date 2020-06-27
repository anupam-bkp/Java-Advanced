package com.example.dbtest.dataJpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

		//Count of instructors
		final long countOfInstructors = instructorService.getCountOfInstructors();
		System.out.println("Total no. of instructors: " + countOfInstructors);


		System.out.println("=============Find Instructor===================");

		//Find one instructor
		int instructorId = 3;

		boolean instructorExists =
				instructorService.checkIFInstructorExists(instructorId);

		if(instructorExists) {
			final Optional<Instructor> instructorById =
					instructorService.findInstructorById(instructorId);

			if(instructorById.isPresent()) { 
				System.out.println(instructorById.get());
			}else { 
				System.out.println("Instructor with Id : " + instructorId + " not exists."); 
			}
		}
			
		//Get one instructor
		/*
		 * instructorId = 3;
		 * 
		 * boolean instructorExists =
		 * instructorService.checkIFInstructorExists(instructorId);
		 * 
		 * System.out.println("instructor exists : " + instructorExists);
		 * 
		 * if(instructorExists) { final Instructor instructorById =
		 * instructorService.getInstructorById(instructorId);
		 * System.out.println(instructorById); }else {
		 * System.out.println("Instructor with Id : " + instructorId + " not exists.");
		 * }
		 */

		// Find All instructors
		final List<Instructor> allInstructors = instructorService.findAllInstructors();
		System.out.println(allInstructors);

		//Find all instructors by id
		final List<Integer> instructorIds = new ArrayList<>(Arrays.asList(1, 2, 4));
		final List<Instructor> instructorsById = 
				instructorService.findInstructorsById(instructorIds);

		System.out.println(instructorsById);

		System.out.println("========================================");

		//Delete instructor
		System.out.println("========Deleting Instructor==============");

		instructorId = 3;
		instructorService.deleteInstructorById(instructorId);

		instructorExists = instructorService.checkIFInstructorExists(instructorId);

		if(instructorExists) {
			final Instructor instructorById = instructorService.getInstructorById(instructorId);
			System.out.println(instructorById);
		}else {
			System.out.println("Instructor with Id : " + instructorId + " not exists.");
		}

		System.out.println("=============================================");
	}

}