package com.shinhan.day06;

class A {
	int score = 100;

	void print() {

	}
}

class B extends A {
	int score2 = 99;

	void print2() {

	}
}

class C extends A {
	int score2 = 99;

	void print2() {

	}
}

class D extends B {

}

class E extends C {

}

public class InheritenceTest5 {
	public static void main(String[] args) {
		method2();
	}

	private static void method2() {
		// 변수의 타입을 따른다.
		A var1 = new B();
		System.out.println(var1.score);
		// System.out.println(var1.score2);
		var1.print();
		// var1.print2();

		if (var1 instanceof B var2) {
			//B var2 = (B) var1;
			System.out.println(var2.score2);
			var2.print2();
		}
	}

	private static void method1() {
		Object obj = new A();
		A a = new A();

		Object b1 = new B();
		B b2 = new B();
		A b3 = new B();

	}

}
