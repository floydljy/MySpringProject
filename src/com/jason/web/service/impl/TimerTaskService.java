package com.jason.web.service.impl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class TimerTaskService {

	private static Logger logger = Logger.getLogger(TimerTaskService.class);
	
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	
	ScheduledFuture<?> taskHandle;
	
	
	public void taskBegin(){
		
		final Runnable task = new Runnable() {
				
			@Override
			public void run() {
				logger.info("timer task is running every five second...");
			}
		};
		System.out.println("task start");
		taskHandle = scheduler.scheduleAtFixedRate(task, 1, 5, TimeUnit.SECONDS);
	
	}
	
	
	public void taskEnd(){
		
		scheduler.shutdown();

	}
}
