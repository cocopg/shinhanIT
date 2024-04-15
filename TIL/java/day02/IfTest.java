package com.shinhan.day02;

public class IfTest {

	public static void main(String[] args) {
		method6();

	}

	private static void method6() {
		char grade = 'A';
		String message;
		grade = Character.toLowerCase(grade);
		switch (grade) {
		case 'a':
			message = "우수회원";
			break;
		case 'b':
			message = "일반회원";
			break;
		default:
			message = "일반손님";
		}
		System.out.printf("%s 입니다", message);
		
		if (grade == 'a') {
			message = "우수회원";
		} else if (grade == 'b') {
			message = "일반회원";
		} else {
			message = "일반손님";
		}
		System.out.printf("\n%s 입니다", message);
		
	}

	private static void method5() {
		char grade = 'a';
		String message;
		if (grade == 'A' || grade == 'a') {
			message = "우수회원";
		} else if (grade == 'B' || grade == 'b') {
			message = "일반회원";
		} else {
			message = "일반손님";
		}
		System.out.printf("%s 입니다", message);

		switch (grade) {
		case 'A', 'a':
			message = "우수회원";
			break;
		case 'B', 'b':
			message = "일반회원";
			break;
		default:
			message = "일반손님";
		}
		System.out.printf("\n%s 입니다", message);

		switch (grade) {
		case 'A', 'a' -> {
			message = "우수회원";
		}
		case 'B', 'b' -> {
			message = "일반회원";
		}
		default->{message = "일반손님";}
		}
		System.out.printf("\n%s 입니다", message);
	}

	private static void method4() {
		// Math: 수학 공식들을 유용하게 사용하기 위한 기능.
		double su = Math.random();// 0<= <1

		int result = (int) (su * 1000000) + 1;
		System.out.println(su);
		System.out.println(result);

	}

	private static void method3() {
		int score = 77;
		String grade;
		switch (score / 10) {
		// case 10,9:grade = "A";break; jdk17부터 지원
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		System.out.printf("%s 학점", grade);

	}

	private static void method2() {
		int score = 80;
		String grade;
		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		System.out.printf("%s 학점", grade);

	}

	private static void method1() {
		int score = 80;
		if (score >= 90) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		System.out.println("if끝");
	}

}
