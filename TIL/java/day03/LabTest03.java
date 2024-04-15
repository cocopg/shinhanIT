package com.shinhan.day03;

import java.util.Arrays;
import java.util.Scanner;

public class LabTest03 {

	public static void main(String[] args) {

		arrayQ4();
	}


	private static void arrayQ4() {
		String addr = "서울시,강남구,역삼동,삼성SDS멀티캠퍼스";
		String[] addrArr = addr.split(addr, ',');
		System.out.println("배열 크기 : " + addrArr.length);
		for (int i = 0; i < addrArr.length; i++) {
			System.out.print(addrArr[i] + " ");
		}
	}

	public String[] split(String str, char separator) {
		int cnt = 0;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == separator) {
				cnt += 1;
			}
		}

		String[] arr = new String[cnt + 1];
		int cnt2 = 0;
		String word = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == separator) {//separator와 같을 때
				arr[cnt2] = word;			//문자열을 arr[cnt2]에 저장
				cnt2+=1;
				word="";					//word초기화
			} else {
				word += str.charAt(i);//문자를 word에 저장
			}
		}
		arr[cnt2]=word;//마지막 문자열 넣기
		return arr; //arr로 돌아가기

	}

	private static void arrayQ3() {
		System.out.println("문자열에 특정문자 변경하는 테스");
		System.out.println("-------------Sample 1 --------------");
		String str1 = myReplace("hello world", 'l', '*');
		System.out.println(str1);

		System.out.println("-------------Sample 2 --------------");
		String str2 = myReplace("hello world", ' ', '-');
		System.out.println(str2);

		System.out.println("-------------Sample 3 --------------");
		String str3 = myReplace("hello world", 'a', '*');
		System.out.println(str3);
	}

	public static String myReplace(String str, char oldChar, char newChar) {
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == oldChar) {
				newStr += newChar;
			} else {
				newStr += str.charAt(i);
			}
		}
		return newStr;
	}

	private static void arrayQ2() {

		int[][] a = { { 30, 30, 30, 30 }, { 40, 40, 40, 40 }, { 50, 50, 50, 50 } };
		int[][] b = { { 1, 2, 3, 4, }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[][] c = new int[3][4];
		method2(a, b, c);

	}

	private static void method2(int[][] a, int[][] b, int[][] c) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}

		}
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j] + " ");
			}
		}

	}

	private static void arrayQ() {
		int[] arr = { 3, 24, 1, 55, 17, 43, 5 };
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
