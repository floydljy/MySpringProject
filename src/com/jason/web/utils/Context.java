package com.jason.web.utils;

import java.util.ArrayList;
import java.util.List;

public class Context {
	
	private static Context context;
	
	private Context(){
		
	}
	
	public static Context getContext(){
		
		if(context == null){
			context= new Context();
		}		
		return context;
	}
}
