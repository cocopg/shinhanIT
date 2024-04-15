package com.shinhan.day04;

import java.util.Scanner;

public class Review {
	public static void main(String[] args) {
		test4();
		System.out.println("끝");

	}

	private static void test4() {
		Scanner sc = new Scanner(System.in);
		int stdCnt = 0;
		int[] scores = null;
		boolean isStop = false;
		while (!isStop) {
			menuPrint();
			System.out.print("선택>");
			int job = sc.nextInt();
			switch (job) {
			case 1 -> {
				System.out.print("학생수>");
				stdCnt = sc.nextInt();
				scores = new int[stdCnt];
			}
			case 2 -> {
				if (scores == null) {
					System.out.println("아직학생수가 입력되지 않았다.점수입력 불가");
					break;
				}
				for (int i = 0; i < stdCnt; i++) {
					System.out.printf("scores[%d]", i);
					scores[i] = sc.nextInt();
				}
			}
			case 3 -> {
				int i = 0;
				for (int score : scores) {
					System.out.printf("scores[%d]: %d\n", i++, score);
				}
			}
			case 4 -> {
				int max = Integer.MIN_VALUE;
				int sum = 0;
				for (int score : scores) {
					if (score > max)
						max = score;
					sum += score;
				}
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + sum / stdCnt);
			}
			case 5 -> {
				isStop = true;
			}
			}
		}
		sc.close();
	}

	private static void menuPrint() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------");
		System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
		System.out.println("--------------------------------------");

	}

	private static void test3() {
		int[][] arr = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };

		System.out.println(arr.length);
		System.out.println(arr[2].length);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void test2() {
		int[][] arr = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int sum = 0;
		int count = 0;
		int avg = 0;

		for (int[] datas : arr) {
			for (int data : datas) {
				sum += data;
				count++;
			}
		}
		/*
		 * for (int i = 0; i < arr.length; i++) { for (int j = 0; j < arr[i].length;
		 * j++) { sum += arr[i][j]; } }
		 */
		System.out.println(sum);
		System.out.println(sum / count);
	}

	private static void method4() {
		int a = 0;
		Integer b = null;
		System.out.println(a);
		System.out.println(b);

		String s = "자바";
		s = s + "프로그램";// StringBuffer.append->String

	}

	private static void test1() {
		int[] arr = { 1, 5, 3, 8, 2, 100, 82, 27, 101 };
		int max = 0; // 모를 땐 제일 작은 값 주기(Integer.MIN_VALUE;)

		/*
		 * for(int data:arr){ if (data>max) max=data; }
		 */

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				max = arr[i + 1];
			} else {
				max = arr[i];
			}
		}
		System.out.println(max);
	}

	private static void method3() {
		int[][] arr = new int[3][4];
		int[][] arr2 = new int[3][];
		int[] arr3[] = new int[3][];
		int arr4[][] = new int[3][];

		for (int i = 0; i < arr4.length; i++) {
			// System.out.println(arr4[i]);
			arr4[i] = new int[i + 2];
			for (int j = 0; j < arr4[i].length; j++) {
				System.out.print(arr4[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void method2() {
		// 1.배열선언+생성
		int[] arr = new int[3];
		// 배열선언+생성+초기화
		int[] arr2 = new int[] { 1, 10, 100, 1000 };
		// 배열선언
		int[] arr3;
		// 2.생성+초기화
		arr3 = new int[] { 1, 2, 3, 4 };

		for (int i = 0; i < arr3.length; i++) {
			System.out.println(i);
		}

	}

	private static void method1() {
		// 배열:같은 타입의 여러개의 값을 저장하기 위한 자료구조
		// heap영역에 연속공간을 만든다.
		// 개수를 알아야 생성가능

		// 1.배열선언
		int a;
		int[] arr = null;
		// 2.배열생성
		arr = new int[3];
		// 3.배열사용
		arr[0] = 100;

	}
}
