package com.example.dbtest.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Instructor retrieveById() {
		final Instructor instructor = 
				jdbcTemplate.queryForObject("SELECT * FROM instructor WHERE id=1", 
						new BeanPropertyRowMapper<>(Instructor.class));
		
		return instructor;
	}
}
