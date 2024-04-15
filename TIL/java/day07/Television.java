package com.shinhan.day07;

//interface를 구현한 구현class
//추상메서드를 반드시 구현할 의무가 있다.
public class Television implements RemoteController {

	@Override
	public void method1() {
		System.out.println(getClass().getSimpleName()+"method1()");
		
	}

	@Override
	public void method2() {
		System.out.println(getClass().getSimpleName()+"method2()");
		
	}

	@Override
	public void turnOn() {
		System.out.println(getClass().getSimpleName()+"전원켠다");
		
	}

	@Override
	public void turnOff() {
		System.out.println(getClass().getSimpleName()+"전원끈다");
	}
	//default메소드는 재정의 가능

	@Override
	public void method3() {
		RemoteController.super.method3();
		System.out.println("default메소드 재정의함");
	}
	void method4() {
		RemoteController.method4(); 	
		System.out.println("method 메서드 추가");
	}
}
