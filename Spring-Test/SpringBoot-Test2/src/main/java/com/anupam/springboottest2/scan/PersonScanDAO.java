package com.anupam.springboottest2.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonScanDAO {

	@Autowired
	JdbcConnectionScan jdbcConnection;

	public JdbcConnectionScan getJdbcConnection() {
		return jdbcConnection;
	}
}
