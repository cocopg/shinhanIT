package com.shinhan.day01;

//JVM이 String 변환 클래스의 main()메서드 호출을 위해 접근권한이 public이다.

public class String변환 {

	public static void main(String[] args) {
		f4();

	}

	private static void f4() {
		int a=100;
		{
			int b=200;
			System.out.println("1."+(a+b));
		}
		if(a>=100) {
			int b=300;
			System.out.println("2."+(a+b));
		}
		
		System.out.println("3."+a);
		//오류 System.out.println(a+b);
	}

	private static void f3() {
		int a=100;
		String s=String.valueOf(a);
		String s2=a+"";
		System.out.println(s);
		System.out.println(s2);
		
	}

	private static void f2() {
		String score="100";
		
		//String에서 +는 연결을 의미한다.
		System.out.println(score+200);//문자
		System.out.println(1+2+score);
		System.out.println(10-2+score);
		
	}

	private static void f1() {
		String score="100";
		
		byte a=Byte.parseByte(score);
		short b=Short.parseShort(score);
		int c=Integer.parseInt(score);
		long d=Long.parseLong(score);
		float e=Float.parseFloat(score);
		double f=Double.parseDouble(score);
		
		System.out.println(a+b+c+d+e+f);
		
	}

}
