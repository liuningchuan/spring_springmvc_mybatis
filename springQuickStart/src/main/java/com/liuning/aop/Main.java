package com.liuning.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {


//		ApplicationContext ac=new ClassPathXmlApplicationContext("com/liuning/aop/beans.xml");

        //无法读取本目录下的文件，只能读取resources下的文件，暂时未找到读取本目录下文件的方法
        //ApplicationContext ac=new ClassPathXmlApplicationContext("aop/beans.xml");
		ApplicationContext ac=new ClassPathXmlApplicationContext("aop-beans.xml");
		TestSayHello ts=(TestSayHello) ac.getBean("proxyFactoryBean");
		ts.sayHello();
		((TestSayBye)ts).sayBye();
		
	}

}
