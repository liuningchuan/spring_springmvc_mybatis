package com.liuning.beanlife;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

	//	ApplicationContext ac=new ClassPathXmlApplicationContext("com/liuning/beanlife/aop-beans.xml");
		
		//@SuppressWarnings("deprecation")
		//BeanFactory factory = new XmlBeanFactory(
				//new ClassPathResource("com/liuning/beanlife/aop-beans.xml"));
		BeanFactory factory =  new ClassPathXmlApplicationContext("com/liuning/beanlife/beans.xml");
		PersonService ps=(PersonService) factory.getBean("personService");
		
		ps.sayHi();
		
		//ps.mydestory();
	
	}
}
