package com.anupam.springboottest1.cdi;

import javax.inject.Inject;
import javax.inject.Named;

//@Component
@Named
public class CdiBusiness {
	
//	@Autowired
	@Inject
	private CdiDao cdiDao;

	public CdiDao getCdiDao() {
		return cdiDao;
	}
}
