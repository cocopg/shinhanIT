package com.shinhan.day10;

import java.io.FileNotFoundException;

//변수(data)+기능(메서드)
class Machine extends Object {
	Machine() {
		super();
		System.out.println("Machine 기본생성자");
	}
}

//규격서:상수+추상메서드+default, static, private 메서드
interface MyInterface {
	public abstract void method1();
}

//상속(부모의 private를 제외한 모든 변수(data)+기능(메서드) 접근, 수정(override), 추가가능(이름 같고 매개변수 다르면 overloading), 추가(이름다름)
class CoffeeMachine extends Machine implements MyInterface, AutoCloseable {

	CoffeeMachine() {
		System.out.println("CoffeeMachine기본생성자");
		
	}

	@Override
	public void close() throws Exception {
		System.out.println("AutoCloseable interface의 close()재정의");

	}

	@Override
	public void method1() {
		System.out.println("method1...구현 클래스가 interface에서 정의한 추상메서드를 구현");

	}

}

public class Review {
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return "Coffee".hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return "Coffee".equals("Coffee");
	}

	public static void main(String[] args) {
		
		

		try (CoffeeMachine coffee1 = new CoffeeMachine();
			 CoffeeMachine coffee2 = new CoffeeMachine();) {
			coffee1.method1();
			coffee2.method1();
			System.out.println(coffee1);//toString 호출
			System.out.println(coffee2);//toString 호출
			System.out.println(coffee1 == coffee2);//주소비교
			System.out.println(coffee1.equals(coffee2));
			// coffee1.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	

}
