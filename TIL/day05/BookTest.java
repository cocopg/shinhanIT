package com.shinhan.day05;

//java.lang아래 있는 class는 import없이 사용가능
//그외에는 반드시 import한다
//외부(다른 패키지에 있는 class를 이용하는 경우 반드시 import하고 사용한다.

public class BookTest {

	public static void main(String[] args) {
		method3();

	}

	private static void method3() {
		int a = Integer.MAX_VALUE;
		
		System.out.println(a);
		
		int b = Integer.compare(10, 3);
		System.out.println(b);
		int c = Integer.max(10,20);
		System.out.println(c);
		int score1=10, score2=20;
		System.out.println(score1>score2?score1:score2);
		
	}

	private static void method2() {
		//Book.ISBN="8888"; 상수는 변경불가
		
		System.out.println(Book.ISBN);
		System.out.println(Book.ISBN2);
		
		Book b1 = new Book();
		//올바른 사용은 아니다.
		System.out.println(b1.ISBN);
		System.out.println(b1.ISBN2);
		
	}

	private static void method1() {
		System.out.println(Book.bookCount);
		
		Book b1 = new Book();
		System.out.println(b1.title);
		System.out.println(b1.price);
		System.out.println(b1.publish);
		System.out.println(b1.publish2);
		System.out.println(b1.publish3);
		
	}

}
