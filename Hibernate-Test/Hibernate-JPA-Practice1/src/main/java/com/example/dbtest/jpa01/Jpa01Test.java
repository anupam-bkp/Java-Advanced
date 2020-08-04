package com.example.dbtest.jpa01;

public class Jpa01Test {

	public static void main(String[] args) {
		
		final DataDaoService daoService = DataDaoService.getInstance();
		daoService.initialize();
		
		System.out.println("==========================");
		ProjectDetail projectDetail = daoService.getProjectDetailById(178);
		
		System.out.println(projectDetail); System.out.println("Managed By : " +
		projectDetail.getEmployee1().getEmpUserName());
		System.out.println("Updated By : " +
		projectDetail.getEmployee2().getEmpUserName());
		
		System.out.println("===========================");
		
		
	}
	
}
