package com.example.dbtest.jpa01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RmsBootApplication implements CommandLineRunner{

	@Autowired
	private RmsDataService rmsDataService;
	
	public static void main(String[] args) {
		SpringApplication.run(RmsBootApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		System.out.println("========================================");
		
		  ProjectDetail projectDetail = rmsDataService.getProjectDetail(178);
		  System.out.println(projectDetail); System.out.println("Managed By : " +
		  projectDetail.getEmployee1().getEmpUserName());
		  System.out.println("Updated By : " +
		  projectDetail.getEmployee2().getEmpUserName());
		  
		  System.out.println("========================================"); projectDetail
		  = rmsDataService.getProjectDetail(384); System.out.println(projectDetail);
		  System.out.println("Managed By : " +
		  projectDetail.getEmployee1().getEmpUserName());
		  System.out.println("Updated By : " +
		  projectDetail.getEmployee2().getEmpUserName());
		 
		System.out.println("=========================================");
	}

}
