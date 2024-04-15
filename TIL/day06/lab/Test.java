package com.shinhan.day06.lab;

class A1 {
}

class B1 extends A1 {
}

class C1 extends A1 {
}

class D1 extends B1 {
}

class E1 extends B1 {
}

class F1 extends C1 {
}

public class Test {
	public static void main(String[] args) {
		B1 b1 = new B1();
		method(new B1());

		//B b2=(B) new A();
		//method((B) new A());

		B1 b3 = new D1();
		method(new D1());

		B1 b4 = new E1();
		method(new E1());

	}

	static void method(B1 b) {
	}
}
