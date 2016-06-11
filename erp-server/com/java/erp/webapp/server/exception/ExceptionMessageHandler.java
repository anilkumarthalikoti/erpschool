package com.java.erp.webapp.server.exception;

import java.util.Properties;

public class ExceptionMessageHandler extends Exception  {
	private String message = null;
	private int errorCode=-1;
	private static Properties errors; 
    public ExceptionMessageHandler() {
        super();
    }
 
    public ExceptionMessageHandler(String message) {
        super(message);
        this.message = message;
    }
 
    public ExceptionMessageHandler(Throwable cause) {
        super(cause);
    }
    public ExceptionMessageHandler(int messageId) {
    	 super();
    	 errorCode=messageId;
    	 
    }
    @Override
    public String toString() {
    	if(errorCode!=-1){
    		message=loadMessage(errorCode);
    	}
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
public void loadProps(){
	if(null==errors){
		errors=new Properties();
		try{
		errors.load(getClass().getClassLoader().getResourceAsStream("message.properties"));
		}catch(Exception e){
			
		}}
}
public String loadMessage(int id){
	if(null==errors){
		loadProps();
	}
	if(null!=errors){
	return	errors.getProperty(id+"");
	}
	return"";
}
}
