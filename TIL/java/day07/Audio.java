package com.shinhan.day07;

public class Audio implements RemoteController {

	int a = 100;
	static int b = 200;
	@Override
	public void method1() {
		System.out.println("Audio default생성자");

	}
	void show() {
		System.out.println("Audio show 메서드");
	}

	@Override
	public void method2() {
		System.out.println("Audio method2()구현");

	}

	@Override
	public void turnOn() {
		System.out.println("Audio turnOn()구현");

	}

	@Override
	public void turnOff() {
		System.out.println("Audio turnOff()구현");

	}

}
