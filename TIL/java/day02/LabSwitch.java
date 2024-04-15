package com.shinhan.day02;

import java.util.Scanner;

public class LabSwitch {

	public static void main(String[] args) {
		printSeason();

	}

	private static void printSeason() {
		Scanner sc = new Scanner(System.in);
		String message;
		System.out.print("자신이 태어난 달을 입력하세요");
		int month = sc.nextInt();

		switch (month) {
		case 3, 4, 5 -> {
			message = "봄에 태어나셨네요";
		}
		case 6, 7, 8 -> {
			message = "여름에 태어나셨네요";
		}
		case 9, 10, 11 -> {
			message = "가을에 태어나셨네요";
		}
		case 1, 2, 12 -> {
			message = "겨울에 태어나셨네요";
		}
		default -> {
			message = "1~12사이의 숫자만 입력하셔야 합니다.";
		}
		}
		System.out.printf(message);
		sc.close();

	}

}
