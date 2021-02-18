package com.liuning.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * 注入方式：
	 * 1、通过set方法注入
	 * 2、通过构造函数注入
	 */
	public static void main(String[] args) {
	
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/liuning/constructor/beans.xml");
	
		Employee ee=(Employee) ac.getBean("employee");
		System.out.println(ee.getName());
	
	}

}
