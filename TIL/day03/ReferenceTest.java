package com.shinhan.day03;

import java.util.Arrays;

public class ReferenceTest {

	public static void main(String[] args) {
		call4();
	}

	private static void call4() {
		String subject = "이것이 자바다 저자는 신용권, 임경균@최재명";
		System.out.println("replace:" + subject.replace("자바", "JAVA"));
		System.out.println("원본불변:" + subject);
		System.out.println("indexOf:" + subject.indexOf("자바"));
		String[] arr=subject.split(",|@| ");
		System.out.println(Arrays.toString(arr));
		
	}

	private static void call3() {
		String subject = "이것이 자바다";
		System.out.println(subject.length());
		System.out.println("substring:" + subject.substring(4));
		System.out.println("substring:" + subject.substring(4, 6));
		System.out.println("charAt:" + subject.charAt(0));

		for (int i = 0; i < subject.length(); i++) {
			System.out.println("charAt:" + subject.charAt(i));
		}

	}

	private static void call2() {
		String s1 = "자바";
		String s2 = "자바";
		String s3 = new String("자바");
		String s4 = new String("자바");

		// String은 고정문자열.
		s1 += "프로그램"; // 주소가 달라진다.
		s2 += "프로그램";

		System.out.println(s1 == s2 ? "주소같다" : "주소다르다");
		System.out.println(s3 == s4 ? "주소같다" : "주소다르다");
		System.out.println(s1.equals(s2) ? "내용이 같다" : "내용이 다르다");
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));

	}

	private static void call() {
		int a = 10;
		String s = null;// null은 정의된 값이 없다는 걸 의미.
		System.out.println("기본형 연습:" + a);
		System.out.println("참조형 연습:" + s);

		try {
			// Exception 발생 가능성이 있는 문장들
			System.out.println("참조형 연습:" + s.length());// NullPointerException
		} catch (NullPointerException aa) {
			System.out.println(aa.getMessage());
			System.out.println("null은 정의된 값이 없다는 걸 의미한다. null은 length불가");
		}
		System.out.println("Exception 발생시 프로그램 중단된다. 복구가능");

	}

}
