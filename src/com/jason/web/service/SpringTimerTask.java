package com.jason.web.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringTimerTask {

	private static Logger logger = Logger.getLogger(SpringTimerTask.class);
	
//	@Scheduled(cron="0/5 * * * * ? ") //每5秒执行一次  
    public void myTest(){  
        logger.info("start SpringTimerTask " + new Date());  
    }
}
