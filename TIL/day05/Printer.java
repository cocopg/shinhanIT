package com.shinhan.day05;

public class Printer {
	static void println(int value) {
		System.out.println(value);
	}
	static void println(boolean value) {
		System.out.println(value);
	}
	static void println(double value) {
		System.out.println(value);
	}
	static void println(String value) {
		System.out.println(value);
	}
	public static void main(String[] args) {
		//Printer printer = new Printer(); static 사용으로 생성할 필요 x
		println(10);
		println(true);
		println(5.7);
		println("홍길동");
	}
}
