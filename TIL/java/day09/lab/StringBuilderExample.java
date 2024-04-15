package com.shinhan.day09.lab;

import java.util.StringTokenizer;

public class StringBuilderExample {
	public static void main(String[] args) {
		String str = "아이디, 이름, 패스워드";
		StringTokenizer st = new StringTokenizer(str, ",| ");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
	
	public static void f1(String[] args) {
		StringBuilder str = new StringBuilder();
		System.out.println(System.identityHashCode(str));
		for (int i = 1; i <= 100; i++) {
			str.append(String.valueOf(i));
			System.out.println(System.identityHashCode(str));
		}
		System.out.println(str);
	}
}
