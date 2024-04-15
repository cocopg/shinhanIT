package com.shinhan.day04;

public class CarTest {

	public static void main(String[] args) {
		method1();

	}

	private static void method1() {
		Car c1 = new Car("G90","black",300);
		String result = c1.carInfoPrint("현대차");
		System.out.println(result);
		
		c1.powerOn();
	}

}
