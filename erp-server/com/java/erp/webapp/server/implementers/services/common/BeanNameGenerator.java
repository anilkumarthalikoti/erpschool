package com.java.erp.webapp.server.implementers.services.common;

import java.beans.Introspector;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.stereotype.Component;
@Component
public class BeanNameGenerator extends AnnotationBeanNameGenerator {
public BeanNameGenerator(){
	   prefix = System.getProperty("beans.name.prefix", null);
	
}
private String prefix;

 
protected String buildDefaultBeanName(BeanDefinition definition) {
    String fqdn = definition.getBeanClassName();
   // System.out.println(fqdn+"-----");
    return Introspector.decapitalize(fqdn);
  }

public String generateBeanName(BeanDefinition definition,
        BeanDefinitionRegistry registry) {
    
    String defaultBeanName = super.generateBeanName(definition, registry);
  // System.out.println(defaultBeanName);
    return null!=prefix? prefix + '.' + defaultBeanName : defaultBeanName;
}
}
