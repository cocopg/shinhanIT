package com.shinhan.day07;

interface Vehicle {
	public void run();
}

class Anonymous {
	Vehicle field = new Vehicle() {
		public void run() {
			System.out.println("자전거가 달립니다.");
		}
	};
	Vehicle field2 = () -> System.out.println("자전거가 달립니다.");

	void method1() {
		Vehicle localVar = new Vehicle() {
			public void run() {
				System.out.println("승용차가 달립니다");

			}
		};
		Vehicle field2 = () -> System.out.println("승용차가 달립니다");
		localVar.run();

	}

	void method2(Vehicle v) {
		v.run();
	}
}

public class AnonymousExample {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method1();
		anony.method2(new Vehicle() {
			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");

			}
		});

	}

}