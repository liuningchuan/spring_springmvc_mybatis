package com.liuning.inter;
/*
 * spring提倡接口编程，配合di技术可以完成层与层之间的解耦
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext  ac = new ClassPathXmlApplicationContext("com/inter/aop-beans.xml");
		
		
//		upperCase changecase = (upperCase) ac.getBean("changeCase");
//		System.out.println(changecase.change());
		
		//使用接口来访问bean
		changeLetter change = (changeLetter) ac.getBean("changeCase");
		System.out.print(change.change());
		
	}

}
