package com.shinhan.day03;

import java.util.Scanner;

public class SwitchExpressionTest {

	public static void main(String[] args) {
		call();
		call2();
		call3();
		call4(6);
		call5();
		call6();
		call7();
		call8();
	}

	private static void call8() {
		Scanner sc = new Scanner(System.in);
		int amount = 0, balance = 0;
		boolean isStop = false;

		while (!isStop) {
			menu();
			String key = sc.nextLine();
			switch (key) {
			case "1":
				System.out.print("예금액");
				amount = Integer.parseInt(sc.nextLine());
				balance += amount;
				break;
			case "2":
				System.out.print("출금액");
				amount = Integer.parseInt(sc.nextLine());
				if (amount > balance) {
					System.out.println("잔고부족, 출금불가");
					break;
				}
				System.out.println(amount + " 정상출금됨");
				balance -= amount;
				break;
			case "3":
				System.out.print("잔고는" + balance);
				break;
			case "4":
				System.out.print("End");
				isStop=true;//flag이용
			default:
				break;
			}

		}
		sc.close();
		System.out.println("종료");

	}

	private static void call7() {
		Scanner sc = new Scanner(System.in);
		int amount = 0, balance = 0;

		aa: while (true) {
			menu();
			String key = sc.nextLine();
			switch (key) {
			case "1":
				System.out.print("예금액");
				amount = Integer.parseInt(sc.nextLine());
				balance += amount;
				break;
			case "2":
				System.out.print("출금액");
				amount = Integer.parseInt(sc.nextLine());
				if (amount > balance) {
					System.out.println("잔고부족, 출금불가");
					break;
				}
				System.out.println(amount + " 정상출금됨");
				balance -= amount;
				break;
			case "3":
				System.out.print("잔고는" + balance);
				break;
			case "4":
				System.out.print("End");
				break aa;// label 빠지기(while빠지기)
			default:
				break;
			}

		}
		sc.close();
		System.out.println("종료");

	}

	private static void menu() {
		System.out.println("-----------------------");
		System.out.println("1.예금|2.출금|3.잔고|4.종료");
		System.out.println("-----------------------");
		System.out.print("선택>");

	}

	private static void call6() {
		for (int row = 1; row <= 5; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	private static void call5() {
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}

	}

	private static void call4(int num) {
		while (true) {
			int num1 = (int) (Math.random() * 6) + 1;
			int num2 = (int) (Math.random() * 6) + 1;
			if (num1 + num2 == num) {
				System.out.printf("(%d, %d)\n", num1, num2);
				break;
			}
		}
		// System.out.println("=============end==============");
	}

	private static void call3() {
		int total = 0;
		for (int su = 0; su <= 100; su += 3) {
			total += su;
		}
		System.out.println(total);
	}

	private static void call2() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A" -> {
			score1 = 100;
		}
		case "B" -> {
			int result = 100 - 20;
			score1 = result;
		}
		default -> {
			score1 = 60;
		}

		}
		System.out.println(score1);
	}

	private static void call() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A":
			score1 = 100;
			break;
		case "B":
			int result = 100 - 20;
			score1 = result;
			break;
		default:
			score1 = 60;
		}
		System.out.println(score1);
	}

}
