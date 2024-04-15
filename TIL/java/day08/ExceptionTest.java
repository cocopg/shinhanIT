package com.shinhan.day08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import com.shinhan.day09.Book;

public class ExceptionTest {

	public static void main(String[] args) {
		// method1(10);
		try {
			method7();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------Main End-------");
	}

	private static void method7() throws IOException, ClassNotFoundException {
		Class.forName("com.shinhan.day09.Book");
		FileReader fi = new FileReader("src/com/shinhan/day08/Book22.java");
		int i;
		while ((i = fi.read()) != -1) {
			System.out.print((char) i);
		}

	}


	private static void method6() {
		try (FileReader fi = new FileReader("src/com/shinhan/day08/Book.java")) {

			int i;
			while ((i = fi.read()) != -1) {
				System.out.print((char) i);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void method5() {
		FileReader fi = null;
		int i;
		try {
			fi = new FileReader("src/com/shinhan/day08/Book.java");
			while ((i = fi.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음" + e.getMessage());

		} catch (IOException e) {
			e.printStackTrace();

		} catch (NullPointerException e) {
			System.out.println("dkseo");

		} finally {
			try {
				if (fi != null)
					fi.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void method4() {
		// 하나의 메서드에서 혹은 클래스에서 같은 이름의 클래스를 이용하는경우 같은 패키지를 먼저 검색
		// 다른 패키지의 클래스는 반드시 패키지 이름까지 사용한다.
		Book a = new Book();
		com.shinhan.day09.Book b = new com.shinhan.day09.Book();
		System.out.println(a);
		System.out.println(b);

		try {
			Class mybook = Class.forName("com.shinhan.day09.Book");
			System.out.println(mybook.getName());
			System.out.println(mybook.getPackageName());
			System.out.println(mybook.getSimpleName());
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println("************");
	}

	private static void method3() throws IOException {
		// RuntimeException이 아닌 일반 Exception : 컴파일시에 체크
		// 반드시 Exception처리를 해야 한다.
		// 1)내개한다 2)떠넘긴다(나를 부른 곳으로 떠넘긴다)
		InputStream input = System.in;

		int data = input.read();
		System.out.println((char) data);

	}

	private static void method2() {
		// RuntimeException이 아닌 일반 Exception : 컴파일시에 체크
		// 반드시 Exception처리를 해야 한다.
		// 1)내개한다 2)떠넘긴다(나를 부른 곳으로 떠넘긴다)
		InputStream input = System.in;
		try {
			int data = input.read();
			System.out.println((char) data);
		} catch (IOException e) {
			System.out.println("IO오류");
		}

	}
	// 오류발생시 자동으로 JVM이 Exception 객체를 생성해서 Exception발생한 곳으로 간다.

	private static void method1(int count) {
		// 예외: 1)RuntimeException...실행시 오류발생 2)일반 Exception
		int score = 100;
		int[] arr = new int[10];
		String s = "가나다라";

		// if(count == 0) return;
		// 오류처리로직과 비즈니스로직 처리가 섞인다. 권장하지 않음

		// try~catch : 오류처리로직과 비즈니스처리 로직을 구별할 수 있다.

		try {
			System.out.println("평균은 " + score / count);
			arr[10] = 99;
			System.out.println(arr[9]);
			System.out.println(Integer.parseInt(s) + 200);

		} catch (NullPointerException ex) {
			System.out.println("NullPointerException" + ex.getMessage());

		} catch (NumberFormatException ex) {
			System.out.println("NumberFormatException" + ex.getMessage());

		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("ArrayIndexOutOfBoundsException" + ex.getMessage());

		} catch (ArithmeticException ex) {
			// Exception 처리함...그러므로 프로그램 중단없이 계속 진행된다.
			System.out.println("연산오류......" + ex.getMessage());

		} catch (Exception ex) {
			System.out.println("Exception" + ex.getMessage());
			ex.printStackTrace();

		} finally {
			System.out.println("오류가 있거나 없거나 무조건 수행하는 업무이다.(finally)");
		}
		System.out.println("--------------");
	}

}
