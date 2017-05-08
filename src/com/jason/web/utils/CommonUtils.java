package com.jason.web.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonUtils {
	
	public static Logger logger = Logger.getLogger(CommonUtils.class.getName());
	
	public void SaveProperties(String propFile, String key, String value){	
		Properties prop = new Properties();   
        try {   
            File file = new File("/" + propFile);   
            if (!file.exists())   
                file.createNewFile();   
            InputStream fis = this.getClass().getResourceAsStream("/" + propFile);
            prop.load(fis);   
            fis.close();//定要在修改之前关闭fis   
            OutputStream fos = new FileOutputStream(this.getClass().getResource("/" + propFile).getPath());   
            prop.setProperty(key, value); 
            prop.store(fos, "Update '" + key + "' value");
            fos.close();   
        } catch (IOException e) {   
            System.err.println("Visit " + propFile + " for updating " + value + " value error:" + e.toString());   
        }
	}
	
	public String GetProperties(String propFile, String key){	
		String value = null;
		try {
			Properties prop = new Properties();   
			InputStream fis = this.getClass().getResourceAsStream("/" + propFile);
			prop.load(fis);
			value = prop.getProperty(key);
			fis.close();
		} catch (Exception e) {
			System.err.println("Visit " + propFile + " for updating " + value + " value error:" + e.toString());
		}
		return value;
	}
}
