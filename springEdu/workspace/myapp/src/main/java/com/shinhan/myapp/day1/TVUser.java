package com.shinhan.myapp.day1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TVUser {
	
	public static void main(String[] args) {
		f5();
	}
	
	private static void f5() {

		ApplicationContext context = new ClassPathXmlApplicationContext("di1.xml");

		/*
		 * TV tv = (TV)context.getBean("samsung1"); TV tv2 = context.getBean("samsung2",
		 * TV.class); TV tv3 = context.getBean("lg", TV.class);
		 * 
		 * tv3.powerOn(); tv3.powerOff();
		 */
		
	}
	
	private static void f4() {
		Resource resource = new ClassPathResource("di1.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		TV tv = (TV)factory.getBean("samsung1");
		TV tv2 = factory.getBean("samsung2", TV.class);
		TV tv3 = factory.getBean("lg", TV.class);
		
		tv3.powerOn();
		tv3.powerOff();
		
	}

	private static void f3() {
		new SamsungTV("ABC");
		//interface패턴을 사용하면 구현객체가 변경되어도 사용법이 같다.
		TV tv = TVFactory.makeTV("lg");
		
		tv.powerOn();
		tv.powerOff();
		
	}

	private static void f2() {
		LgTV tv = new LgTV();
		//interface패턴을 사용하면 구현객체가 변경되어도 사용법이 같다.
		tv.powerOn();
		tv.powerOff();
		
	}
	
	private static void f1() {
		SamsungTV tv = new SamsungTV("ABC");
		tv.powerOn();
		tv.powerOff();
		
	}
}
