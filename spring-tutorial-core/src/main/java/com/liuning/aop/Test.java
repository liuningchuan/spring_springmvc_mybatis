package com.liuning.aop;

public class Test implements TestSayHello,TestSayBye {

	private String name;
	
	public String getName() 			{	return name;		}
	public void setName(String name) 	{	this.name = name;	}

	@Override
	public void sayHello() {
		System.out.println("hi "+name);
	}

	@Override
	public void sayBye() {
		System.out.println("bye "+name);
	}

}
