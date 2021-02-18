package com.liuning.dispatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
	
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/liuning/dispatch/beans.xml");
	
		DBUtil dbUtil=(DBUtil) ac.getBean("dbutil2");
		
		System.out.println(dbUtil.getDrivername()+" "+dbUtil.getName());
	
	}

}
