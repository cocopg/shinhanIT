package com.shinhan.day02;

import java.util.Scanner;

public class TestTest {

	public static void main(String[] args) {

		bank();
		
	}

	private static void bank() {
		Scanner sc = new Scanner(System.in);
		boolean run=true;
		
		while(run) {
			System.out.println("-----------------------");
			System.out.println("1.예금|2.출금|3.잔고|4.종료");
			System.out.println("-----------------------");
			System.out.print("선택>");
			int num = sc.nextInt();
			
			if(num==1) {
				System.out.print("예금액>");
				int mny1 = 10000;
				
			}
			
		}
		
		
	}

	private static void gcd(int num1, int num2) {
		// int min = num1>num2?num2:num1;
		int min = Math.min(num1, num2);
		int result = 1;
		for (int i = min; i > 1; i--) {
			if (num1 % i == 0 && num2 % i == 0) {
				result = i;
				break;
			}
			
		}
		System.out.println(result);

	}

	private static void numsDay(int year, int month) {
		int day;

		switch (month) {
		case 2: {
			if (year % 4 == 0) {
				if (year % 400 == 0 || year % 100 != 0) {
					day = 29;
				} else {
					day = 28;
				}
			} else {
				day = 28;
			}
			break;
		}
		case 4, 6, 9, 11: {
			day = 30;
			break;
		}
		default: {
			day = 31;
			break;
		}
		}
	}

	private static void test6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("해를 입력하세요 : ");
		int year = sc.nextInt();
		System.out.print("달을 입력하세요 : ");
		int month = sc.nextInt();
		sc.close();

		int day;

		switch (month) {
		case 2: {
			if (year % 4 == 0) {
				if (year % 400 == 0 || year % 100 != 0) {
					day = 29;
				} else {
					day = 28;
				}
			} else {
				day = 28;
			}
			break;
		}
		case 4, 6, 9, 11: {
			day = 30;
			break;
		}
		default: {
			day = 31;
			break;
		}
		}
		System.out.printf("%d년 %d월의 말일은 %d일 입니다.", year, month, day);
	}

	private static void test5() {
		int start = 1;
		int step = 0;
		int sum = 0;
		int num = 15;
		for (int i = start; step < num; i += step) {
			sum += i;
			step++;

		}
		System.out.printf("%d번째까지의 합 :%d\n", num, sum);

	}

	private static void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요:");
		int num = sc.nextInt();
		int cnt = 0;
		int sum = 0;
		for (int i = num; i <= 1000; i++) {
			if (i % num == 0) {
				cnt++;
				sum += i;
			}

		}
		System.out.printf("%d의 배수의 개수 = %d\n", num, cnt);
		System.out.printf("%d의 배수 합 = %d", num, sum);

	}

	private static void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요:");
		int num = sc.nextInt();
		int fact = 1;

		if (num < 2 || num > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다");
		} else {
			for (int i = 1; i <= num; i++) {
				fact *= i;
				System.out.printf("%d", i);
				System.out.printf(i == num ? "=" : "*");
			}
			System.out.printf("%d\n", fact);
		}
		sc.close();
	}

	private static void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("2~100사이의 정수를 입력하세요:");
		int num = sc.nextInt();
		int count = 0;

		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		if (count == 2) {
			System.out.printf("%d는(은) 소수입니다", num);
		} else {
			System.out.printf("%d는(은) 소수가 아닙니다", num);
		}

	}

	private static void test0() {
		for (int sum = 1; sum <= 9; sum++) {
			if (sum == 4)
				continue; // loop안의 문장 무시, 조건문으로 이동
			for (int dan = 2; dan <= 9; dan++) {
				System.out.printf("%d*%d=%d\t", dan, sum, dan * sum);
			}
			System.out.println();
		}
	}

	private static void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요:");
		int num = sc.nextInt();
		int sum;
		if (num < 2 || num > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다");
			return;
		} else {
			for (int i = 1; i <= 9; i++) {
				sum = num * i;
				System.out.printf("%d * %d = %d", num, i, sum);
			}
		}
	}

	private static void method5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("직각 역삼각형을 출력할 줄 수:");
		int num = sc.nextInt();
		for (int row = 1; row <= num; row++) {
			for (int col = 1; col <= num + 1 - row; col++) {
				System.out.print("@");
			}
			System.out.println();
		}

	}

	private static void hokeyGraphics(char cell, int size, boolean isRest) {
		if (isRest == true) {
			for (int row = 1; row <= size; row++) {
				for (int col = 1; col <= size; col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		} else {
			for (int row = 1; row <= size; row++) {
				for (int col = 1; col <= row; col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		}

	}

	private static void quest3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요");
		int num = sc.nextInt();
		int total = 0;
		int start;
		if (num % 2 == 0) {
			start = 0;
		} else {
			start = 1;
		}
		for (int i = start; i <= num; i += 2) {
			total += i;
		}
		System.out.println("결과 값:" + total);
	}

	private static void quest2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요");
		String word = sc.nextLine().toUpperCase();
		for (int i = 1; i <= word.length(); i++) {
			System.out.println(word.substring(0, i));
		}
		sc.close();
	}

	private static void quest1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("초기값을 정수로 입력하세요.:");
		int firstNum = sc.nextInt();
		System.out.print("마지막값을 정수로 입력하세요.:");
		int lastNum = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요.:");
		int step = sc.nextInt();
		int sum = 0;

		for (int i = firstNum; i <= lastNum; i += step) {
			sum += i;

		}

		if (sum > 1000)
			sum += 2000;
		System.out.printf("총합은 %d입니다", sum);
		sc.close();
	}
}
