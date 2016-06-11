package com.java.erp.webapp.server.implementers.services.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.java.erp.webapp.server.interfaces.services.common.Response;

public class ProcessMessage {
	private static Properties messageCodes=null; 
	public static void loadProps(){
		if(null==messageCodes){
			messageCodes=new Properties();
			try{
			messageCodes.load(ProcessMessage.class.getClassLoader().getResourceAsStream("message.properties"));
			}catch(Exception e){
				e.printStackTrace();
			}}
	}
	public static String loadMessage(Integer id){
		if(null==messageCodes){
			loadProps();
		}
		if(null!=messageCodes){
		return	messageCodes.getProperty(id.toString());
		}
		return"";
	}
	public static void addMessage(Response response,int code){
		
		String message=loadMessage(code);
		
		final List<String> messages=new ArrayList<String>();
		 
		System.out.println("Messsage Processed:"+message);
		messages.add(message);
		response.setSuccess(messages);
		
	}
}
