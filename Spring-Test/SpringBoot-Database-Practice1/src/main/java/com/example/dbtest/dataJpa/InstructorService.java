package com.example.dbtest.dataJpa;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

	@Autowired
	private InstructorJpaRepository instructorJpaRepo;
	
	@Transactional
	public long getCountOfInstructors() {
		return instructorJpaRepo.count();		//CrudRepository
	}
	
	@Transactional
	public boolean checkIFInstructorExists(final Integer id) {
		return instructorJpaRepo.existsById(id);	//CrudRepository
	}
	
	@Transactional
	public Instructor getInstructorById(final Integer id) {
		//Not Working
		return instructorJpaRepo.getOne(id);		//JpaRepository
	}
	
	@Transactional
	public Optional<Instructor> findInstructorById(final Integer id){
		return instructorJpaRepo.findById(id);		//CrudRepository
	}
	
	@Transactional
	public List<Instructor> findInstructorsById(final Iterable<Integer> ids) {
		 return instructorJpaRepo.findAllById(ids);		//JpaRepository
	}

	@Transactional
	public List<Instructor> findAllInstructors(){
		return instructorJpaRepo.findAll();			//JpaRepository
	}
	
	@Transactional
	public void deleteInstructorsInBatch(final Iterable<Instructor> entities) {
		instructorJpaRepo.deleteInBatch(entities);  //JpaRepository
	}
	
	@Transactional
	public void deleteAllInstructorsInBatch() {
		instructorJpaRepo.deleteAllInBatch();    //JpaRepository
	}
	
	@Transactional
	public void deleteInstructorById(final Integer id) {
		instructorJpaRepo.deleteById(id);		//CrudRepository
	}
	
	@Transactional
	public void deleteInstructor(final Instructor entity) {
		instructorJpaRepo.delete(entity);		//CrudRepository
	}
	
	@Transactional
	public void deleteInstructors(final Iterable<Instructor> entities) {
		instructorJpaRepo.deleteAll(entities);		//CrudRepository
	}
	
	@Transactional
	public void deleteAllInstructors() {
		instructorJpaRepo.deleteAll();      //CrudRepository
	}
	
	@Transactional
	public void addInstructor(final Instructor entity) {
		instructorJpaRepo.save(entity);   //CrudRepository
	}
	
	@Transactional
	public void addInstructors(final Iterable<Instructor> entities) {
		instructorJpaRepo.saveAll(entities);	//JpaRepository
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
