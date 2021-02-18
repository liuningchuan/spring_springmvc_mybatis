package com.liuning.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/liuning/autowire/beans.xml");
		
		Master master=(Master) ac.getBean("master");
		System.out.println(master.getName()+" "+master.getDog().getName());
	}

}
