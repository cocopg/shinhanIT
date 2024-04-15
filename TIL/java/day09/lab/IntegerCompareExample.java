package com.shinhan.day09.lab;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

public class IntegerCompareExample {
	public static void main(String[] args) {
		 String id = "5Angel1004";
		 //String regExp = "^[0-9][0-9A-Za-z]{8,2}";
		 String regExp = "^[0-9]\\w{8,2}[^z]";
		 boolean isMatch = Pattern.matches(regExp, id);
		 if(isMatch) {
		 System.out.println("ID로 사용할 수 있습니다.");
		 } else {
		 System.out.println("ID로 사용할 수 없습니다.");
		 }
		}
	
	
	
	public static void f3(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분");
		Date d = new Date();
		System.out.println(sdf.format(d));
	}

	public static void f2(String[] args) {
		double d = Math.random();
		System.out.println(d);
		Random r = new Random();
		double d2 = r.nextDouble(10);
		System.out.println(d2);

		int i = r.nextInt(45);
		System.out.println(i);
	}

	public static void f(String[] args) {
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;

		System.out.println(obj1 == obj2);
		System.out.println(obj3 == obj4);
		System.out.println(obj1.equals(obj2));
		System.out.println(obj3.equals(obj4));
	}
}
