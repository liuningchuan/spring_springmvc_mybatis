package com.liuning.inherit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/liuning/inherit/beans.xml");
	
		Gradate gradate=(Gradate) ac.getBean("grdate");
		
		System.out.println(gradate.getName()+" "+gradate.getAge()+" "+gradate.getDegree());
	}

}
