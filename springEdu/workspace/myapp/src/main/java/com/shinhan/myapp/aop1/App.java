package com.shinhan.myapp.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aop1.xml");
		
		Calculator cal = ctx.getBean("proxyCal", Calculator.class);
		int result = cal.add(10, 20);
		System.out.println("합계는:" + result);
	}
}
