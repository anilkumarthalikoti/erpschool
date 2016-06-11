package com.java.erp.webapp.server.aop;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.java.erp.webapp.server.implementers.services.common.Result;
import com.java.erp.webapp.server.interfaces.services.common.Response;

@Aspect
@Component
public class ResultAop {
  
    @Around("within(com.java.erp.webapp.server..*)")
    public Object logging(ProceedingJoinPoint thisJoinPoint) throws Throwable {
       // System.out.println("Before " + thisJoinPoint.getSignature());
        Object ret = null;
        try{
        	ret=thisJoinPoint.proceed();
        }catch(Exception e){
        	Response response=  new Result();
        	List error=new ArrayList<String>();
        	error.add(e.getMessage());
        	response.setErrors(error);
        	ret=response;
        }
       // System.out.println("After " + thisJoinPoint.getSignature());
 
        return ret;
    }
      
}
