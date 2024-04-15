package com.shinhan.day05;

public class CalculatorTest {

	public static void main(String[] args) {
		System.out.println(Calculator.company);
		System.out.println(Calculator.company2);
		System.out.println(Calculator.plus(1, 2));
		// 객체생성 안함 System.out.println(Calculator.minus(1, 2));
		Calculator cal = new Calculator();
		cal.minus(1, 2);

		double result = new Calculator().minus(1, 2);
		System.out.println(result);
	}

}
