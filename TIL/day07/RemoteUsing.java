package com.shinhan.day07;

public class RemoteUsing {

	public static void main(String[] args) {
		f7();

	}

	private static void f7() {
		//Television a= new Television();
		//Audio a= new Audio();
		RemoteController a = new Television();
		a.method1();
	}

	private static void f6() {
		//String, Integer class는 Comparable interface구현.
		//Comparable interface : 추상메서드 public abstact compareTo();
		//String class가 Comparable interface 구현 ... compareTo()재정의
		String s1 = "A";
		String s2 = "C";
		Integer i1 = 100;
		Integer i2 = 105;
		
		int result = s1.compareTo(s2);
		System.out.println(result);
		
		result = i1.compareTo(i2); //-1, 0, 1
		System.out.println(result);
	}

	private static void f4() {
		SmartTelevision a = new SmartTelevision();
		RemoteController b = new SmartTelevision();
		Searchable c = new SmartTelevision();
		Object d = new SmartTelevision();
		
		f5(a);
		f5(b);
		f5(c);
		f5(d);
		
	}

	private static void f5(Object smart) {
		((SmartTelevision)smart).search("http://youtube.com");
		if(smart instanceof SmartTelevision ss)ss.search("http://youtube.com");
		
	}

	private static void f3() {
		action(new Television());
		action(new Audio());
	}

	private static void action(RemoteController remote) {
		// 사용할 변수, 메서드는 타입을 따른다.

		// 상수접근
		System.out.println(remote.CHANNEL);

		// abstract
		remote.turnOn();
		remote.turnOff();
		remote.method1();
		remote.method2();

		// default
		remote.method3();

		// static
		RemoteController.method4();
	}

	private static void f2() {
		Audio audio = new Audio();
		audio.method1();
		audio.method2();
		audio.method3();
		audio.turnOn();
		audio.turnOff();
		audio.show();
		RemoteController.method4();
	}

	private static void f1() {
		Television t1 = new Television();
		// t1.method1();//추상구현
		// t1.method2();//추상구현
		// t1.method3();//default재정의
		// t1.method4();//class에서 추가한 메서드
		RemoteController.method4();

		System.out.println(RemoteController.CHANNEL);
		System.out.println(RemoteController.CHANNEL2);
	}

}
