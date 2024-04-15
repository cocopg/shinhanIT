package com.shinhan.day07;

public class LambdaTest3 {

	public static void main(String[] args) {
		Person p = new Person(10, 20);
		p.action(new ComputeInterface() {

			@Override
			public double calc(double x, double y) {
				System.out.println("--1. 익명구현클래스(-)");
				return x - y;
			}
		});
		p.action((a, b) -> {
			System.out.println("2.람다표현식 구현");
			return a+b;
		});
		//이미 만들어진 static메서드를 사용하기
		p.action(Computer::staticMethod);
		//이미 만들어진 instance메서드를 사용하기
		Computer com = new Computer();
		p.action(com::instanceMethod);
	}

}
