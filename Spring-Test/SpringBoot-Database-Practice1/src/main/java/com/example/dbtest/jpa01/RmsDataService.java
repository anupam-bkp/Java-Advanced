package com.example.dbtest.jpa01;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RmsDataService {

	@Autowired
	private RmsDao rmsDao;
	
	@Transactional
	public ProjectDetail getProjectDetail(int id) {
		return rmsDao.getPrjDetailById(id);
	}
	
}
