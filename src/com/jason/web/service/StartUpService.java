package com.jason.web.service;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class StartUpService {

	private static Logger logger = Logger.getLogger(StartUpService.class);
	
	@PostConstruct
	public void testStart(){
		
		logger.info("The service is started up.");
	}
	
	
}
