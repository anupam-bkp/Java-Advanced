package com.example.dbtest.jpa01;

public class DataDaoService {

	private static final DataDaoService INSTANCE = new DataDaoService();
	
	private DataDao rmsDao;
	
	private DataDaoService() {
		//For Singleton
	}
	
	public void initialize() {
		rmsDao = DataDao.getInstance();
		rmsDao.initialize();
	}
	
	public static DataDaoService getInstance() {
		return INSTANCE;
	}
	
	public ProjectDetail getProjectDetailById(int id) {
		return (ProjectDetail)rmsDao.getEntityById(ProjectDetail.class, id);
	}
	
}
