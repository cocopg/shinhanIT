package com.shinhan.day02;

public class LoopingTest {

	public static void main(String[] args) {
		method4();

	}

	private static void method4() {
		//3행 4열
		int row;
		int col;
		for(row=1;row<=3;row++) {
			for(col=1;col<=4;col++) {
				System.out.printf("%d행 %d열\t",row, col);
			}
			System.out.println();
		}
		
	}

	private static void method3() {
		int i = 1;
		do {
			System.out.println(i + ": while문 연습");
			i++;
		} while (i <= 10);
		System.out.println(i);

	}

	private static void method2() {
		int i = 1;
		while (i <= 10) {
			System.out.println(i + ": while문 연습");
			i++;
		}
		System.out.println(i);
	}

	private static void method1() {
		// 1.for문-조건에 맞는 동안 반복
		int i;
		for (i = 1; i <= 10; i++) {
			System.out.println(i + ". java배우기");
		}
		System.out.println(i);
	}

}
