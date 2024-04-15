package com.shinhan.day09;

import java.util.HashSet;

public class ObjectTest {

	public static void main(String[] args) {
		f3();

	}

	private static void f3() {
		ComputerVO com1 = new ComputerVO(null, 100, "Samsung");
		ComputerVO3 com2 = new ComputerVO3("A", 100, "Samsung");
		ComputerVO3 com3 = new ComputerVO3("A", 100, "Samsung");
		ComputerVO2 aa = new ComputerVO2("B", 1000, "CC");
		System.out.println(aa.model());

	}

	private static void f2() {
		ComputerVO2 com1 = new ComputerVO2("A", 100, "Samsung");
		ComputerVO2 com2 = new ComputerVO2("A", 100, "Samsung");
		System.out.println(com1);// toString 호출
		System.out.println(com2);
		System.out.println(com1.equals(com2));

	}

	private static void f1() {
		ComputerVO com1 = new ComputerVO("A", 100, "Samsung");
		ComputerVO com2 = new ComputerVO("A", 100, "Samsung");
		System.out.println(com1);// toString 호출
		System.out.println(com2);

		System.out.println(com1 == com2); // 주소 비교, 재정의불가
		System.out.println(com1.equals(com2)); // equals:주소비교, 재정의 가능

		// 동일객체비교
		// Set: 순서없고 중복불가
		HashSet<ComputerVO> computers = new HashSet<>();
		computers.add(com1);
		computers.add(com2);

		computers.add(new ComputerVO("A", 100, "Samsung"));

		System.out.println(computers.size());

		for (ComputerVO com : computers) {
			System.out.println(com);
		}
	}

}
