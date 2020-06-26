package com.example.dbtest.dataJpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

	@Autowired
	InstructorJpaRepository instructorJpaRepo;
	
	@Transactional
	public List<Instructor> findAllInstructors(){
		return instructorJpaRepo.findAll();
	}
	
	@Transactional
	public Instructor findInstructorById(Integer id){
		return instructorJpaRepo.getOne(id);
	}
	
	public void test() {
		
		instructorJpaRepo.count();			//CrudRepository
//		instructorJpaRepo.count(Example);	//QueryByExampleExecutor
		
		instructorJpaRepo.delete(null);		//CrudRepository
		instructorJpaRepo.deleteAll();		//CrudRepository
		instructorJpaRepo.deleteAll(null);	//CrudRepository
		instructorJpaRepo.deleteAllInBatch();   //JpaRepository
		instructorJpaRepo.deleteById(0);		//CrudRepository
		instructorJpaRepo.deleteInBatch(null);	//JpaRepository
		
//		instructorJpaRepo.exists(Example); 		//QueryByExampleExecutor
		instructorJpaRepo.existsById(0);		//CrudRepository
		
		instructorJpaRepo.findAll();			//JpaRepository
//		instructorJpaRepo.findAll(Example)		//JpaRepository
//		instructorJpaRepo.findAll(Pageable);	//PagingAndSortingRepository
//		instructorJpaRepo.findAll(Sort);		//JpaRepository
//		instructorJpaRepo.findAll(Example, Pageable) //QueryByExampleExecutor
//		instructorJpaRepo.findAll(Example, Sort)	//JpaRepository
		instructorJpaRepo.findAllById(null);	//JpaRepository
		instructorJpaRepo.findById(0);			//CrudRepository
//		instructorJpaRepo.findOne(Example);		//QueryByExampleExecutor
		
		instructorJpaRepo.flush();			//JpaRepository
		
		instructorJpaRepo.getOne(0);		//JpaRepository
		
		instructorJpaRepo.save(null);		//CrudRepository
		instructorJpaRepo.saveAll(null);	//JpaRepository
		instructorJpaRepo.saveAndFlush(null); //JpaRepository
	}
	
}
