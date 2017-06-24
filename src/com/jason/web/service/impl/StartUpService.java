package com.jason.web.service.impl;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
/*
 * 
 * start up service for the code need to be triggered when the application is starting. 
 * 
 */
@Service
public class StartUpService {

	private static Logger logger = Logger.getLogger(StartUpService.class);
	
	@PostConstruct
	public void testStart(){
		
		logger.info("The service is started up.");
		
		//run timer task service.
		//TimerTaskService timerTaskService = new TimerTaskService();
		//timerTaskService.taskBegin();
		
	}
	
	
}
