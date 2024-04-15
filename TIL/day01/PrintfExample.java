package com.shinhan.day01;

public class PrintfExample {
	
	public static void main(String[] args) {
		f1();
	}
	
	private static void f4() {
		int a=100;
		String b="자바";
		System.out.printf("a=%d\n",a);
		System.out.printf("b=%s",b);
		
	}

	private static void f3() {
		System.out.println("One");
		System.out.println("Two");
		System.out.println("Three");
		
	}
	
	private static void f2() {
		System.out.print("One\t");
		System.out.print("Two\t");
		System.out.print("Three\t");
		
	}

	public static void f1() {
		int value = 123;
		System.out.printf("상품의 가격:%d원\n", value);
		System.out.printf("상품의 가격:%6d원\n", value);//6칸띄고 우측정렬
		System.out.printf("상품의 가격:%-6d원\n", value);//6칸띄고 좌측정렬
		System.out.printf("상품의 가격:%06d원\n", value);

		double area = 3.14159 * 10 * 10;
		System.out.printf("반지름이 %d인 원의 넓이:%-10.2f\n", 10, area);

		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s\n", 1, name, job);
	}
}	