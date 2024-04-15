package com.shinhan.day03;

import java.util.Arrays;

//>java ArrayTest
//JVM이 class load(byte code가 method영역으로 들어간다.)
//검증
//main시작

public class ArrayTest {
	// 명령행 매개변수(argument)
	// 2개 입력받아서 사칙연산 수행하기
	public static void main(String[] args) {

		if (args.length == 2) {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			System.out.println(num1 + num2);
			System.out.println(num1 - num2);
			System.out.println(num1 * num2);
			System.out.println(num1 / num2);
			System.out.println(num1 % num2);
		}
		// method2();

	}

	private static void method2() {
		int[] arr = new int[] { 10, 20, 30 };
		String[] arr2 = { "자바", "디비", "웹" };
		System.out.println("----일반for1----");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + "번째=>" + arr[i]);

		}
		System.out.println("====향상for, 확장for====1");
		for (int data : arr) {
			System.out.println(data);
		}
		for (String data : arr2) {
			System.out.println(data);
		}
	}

	private static void method1() {
		int[] arr = new int[] { 10, 20, 30 };
		int[] arr2 = arr;// 주소 복사
		int[] arr3 = new int[arr.length];
		System.arraycopy(arr, 0, arr3, 0, arr.length);
		arr[0] = 99;
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));

	}

	private static void call9() {
		String[][] arr = new String[3][];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new String[] { "자바" + i, "DB" + i };
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

	private static void call8() {
		// 배열선언+생성+초기화
		String[] arr = new String[] { "자바", "DB", "WEB", "Framework" };
		String[] arr2 = new String[4];// null로 초기화
		arr2[0] = "자바";
		arr2[1] = "DB";
		arr2[2] = "WEB";
		arr2[3] = "Framework";
		arr[0] += "";
		arr[1] += "아";

		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + "----");
			System.out.print(arr2[i] + "----");
			System.out.print(arr[i] == arr2[i] ? " 주소가 같다" : " 주소가 다르다" + "----");
			System.out.println(arr[i].equals(arr2[i]) ? " 내용 같다" : " 내용 다르다");
		}

	}

	private static void call7() {
		int[][] scores = new int[][] { { 10, 20, 30, 40 }, { 1, 2, 3 } };
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				sum += scores[i][j];
				System.out.printf("[%d][%d]=>%d\n", i, j, scores[i][j]);
			}
		}
		System.out.println(sum);

	}

	private static void call6() {
		char[][] arr = { { 'A', 'B', 'C' }, { '가', '나' }, { 'a', 'b', 'c', 'd' } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void call5() {
		// 2차원배열
		int[][] arr;
		int[] arr2[];
		int arr3[][];
		// 선선+생성+초기화
		int arr4[][] = { { 99, 88 }, { 77, 66, 55 } };
		// 배열생성
		arr = new int[3][4];
		arr2 = new int[3][];
		// 배열생성+초기화
		arr3 = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 }, { 9 } };
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		System.out.println(arr4[0][1]);
		System.out.println(arr3[2][2]);
	}

	private static void call4() {
		// 1.선언
		// 2.생성+초기화
		int[] arr;
		arr = new int[] { 20, 40, 60 };// 자동생성이 안됨.
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째" + arr[index]);

		}
	}

	private static void call3() {
		// 선언+생성+초기화
		int[] arr = /* new int[] */ { 10, 20, 30, 40, 50 };
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째" + arr[index]);

		}
	}

	private static void call2() {
		// 선언+생성
		int[] arr = new int[10];
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째" + arr[index]);

		}
	}

	private static void call() {
		// 변수:하나의 값을 저장하기 위한 기억장소 이름
		// 같은 타입의 값을 여러개 저장하고자 한다.(하나의 이름으로 연속공간을 index로 참조한다.)

		// 1.배열선언
		int[] arr1;
		double[] arr2;
		boolean[] arr3;
		char[] arr4;
		String[] arr5;
		// 2.배열생성...반드시 개수를 알아야한다.
		// 정수->0 실수->0.0 boolean->false char->'', 참조형->Null
		arr1 = new int[10];
		arr2 = new double[10];
		arr3 = new boolean[10];
		arr4 = new char[10];
		arr5 = new String[10];
		// 3.배열사용
		System.out.println(arr1[0]);
		System.out.println(arr2[0]);
		System.out.println(arr3[0]);
		System.out.println(arr4[0]);
		System.out.println(arr5[0]);

	}

}
