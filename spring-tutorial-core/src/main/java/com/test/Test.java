package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.service.UserService;
import com.util.ApplicationContextUtil;
public class Test {
	public static void main(String[] args){
		
		//传统方法调用UserService的sayHello方法
//		UserService user = new UserService();
//		user.setName("武汉大学");
//		user.sayHello();
		
		//使用spring完成sayHello方法调用
		//得到spring的applicationContext对象
//		ApplicationContext  ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserService us = (UserService)ac.getBean("user");
//		us.sayHello();
		
		//把ApplicationContext做成一个单例模型
		//((UserService)ApplicationContextUtil.getAplicationContext().getBean("user")).sayHello();
		
		//从bean中得到UserService,容器中的bean不会被立即实例化
		//@SuppressWarnings("deprecation")
		//BeanFactory factory = new XmlBeanFactory(
		//		new ClassPathResource("applictionContext.xml"));
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService us = (UserService) factory.getBean("user");
		
		us.sayHello();
		
	}
}
