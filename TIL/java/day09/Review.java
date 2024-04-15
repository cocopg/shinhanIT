package com.shinhan.day09;

import java.io.FileNotFoundException;
import java.io.IOException;

//정의는 있고 구현은 없다
interface MyInterface {
	public abstract void method1();

	void method2() throws FileNotFoundException;

	void method3() throws Exception;
}

//구현class
//1.부모의 throws Exception이 존재하지 않은 경우 : 없거나 RuntimeException가능
//2.자식은 부모의 Exception보다 하위여야 한다.
class MyClassImple implements MyInterface {

	@Override
	public void method1() throws RuntimeException {
		System.out.println("method1");
	}

	@Override
	public void method2() throws FileNotFoundException {
		System.out.println("method2");
	}

	@Override
	public void method3() throws Exception {
		System.out.println("method3");
	}

}

public class Review {
	// 1.field
	MyInterface a = new MyClassImple();
	// 익명구현클래스
	MyInterface a2 = new MyClassImple() {

		public void method1() {
		}

		public void method2() {
		}

		public void method3() {
		}
	};

	public static void main(String[] args) {
		// 2.local변수
		MyInterface a = new MyClassImple();
		MyInterface a2 = new MyInterface(){
			public void method1() {
			}

			public void method2() {
			}

			public void method3() {
			}
		};

		
	}

	private static void call(MyInterface c) {

	}

}
