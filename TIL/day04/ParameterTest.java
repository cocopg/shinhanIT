package com.shinhan.day04;

public class ParameterTest {

	public static void main(String[] args) {
		ParameterTest aa = new ParameterTest();
		aa.sum(10, 20);
		aa.sum(10, 20, 30); //자동형변환==>실수3으로 간다
		aa.sum(10, 20, 30, 4);
		aa.sum(10, 20, 30, 4, 5);
		aa.sum(10, 20, 30, 4, 5, 6);
		aa.sum(10, 20, 30, 4, 5, 6, 7);

		int[] values = { 1, 2, 4, 5, 6, 7, 8, 9, 10 };
		sum(values);

		sum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

		sum("자바", "프로그램");

		sum(3.14, 10.5, 9.7);

	}

	private static void sum(double d, double e, double f) {
		System.out.println("실수합:" + (d + e + f));

	}

	private static void sum(String string, String string2) {
		System.out.println("word2:" + string + string2);

	}

	private static void sum(int... datas) {
		int total = 0;
		for (int data : datas) {
			total += data;
		}
		System.out.println("가변길이 매개변수:" + total);
	}

	private void sum(int i, int j, int k) {
		System.out.println("정수합: " + (i + j + k));

	}

	private static void sum(int i, int j) {
		System.out.println("정수합: " + (i + j));

	}

	// 멤버메서드(non-static) : 객체생성 후 호출이 가능하다.
	// static은 static에서만 호출이 가능하다.
	void print() {
		sum(1, 2);
	}

}
