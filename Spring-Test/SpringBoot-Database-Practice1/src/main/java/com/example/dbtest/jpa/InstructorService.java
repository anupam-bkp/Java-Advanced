package com.example.dbtest.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

	@Autowired
	InstructorJpaDao instructorJpaDao;
	
	@Transactional
	public List<Instructor> getAllInstructors(){
		return instructorJpaDao.getAllInstructors();
	}
	
}
