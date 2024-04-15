package com.shinhan.day01;

public class 형변환 {

	//byte < short=char < int < long < float < double
	public static void main(String[] args) {
		f2();

	}

	private static void f2() {
		long var1;
		int var2=100;
		//자동형변환
		var1=var2;
		System.out.println(var1);
		
		//4byte방 = 8byte값 : 불가
		//강제형변환
		var1 = 2147483648L;
		var2 = (int)var1;
		System.out.println(var2);
		
		String str = "100";
		//int i = (int)str;
		//기본형은 casting하여 형변환한다.
		//객체는 기능(함수, 메서드)으로 형변환한다.
		
		int i=Integer.parseInt(str);
		System.out.println(i);
	}

	private static void f1() {
		System.out.println("형변환에 대하여");
		//**자동 형변환이 된다.
		//큰방 = 작은값
		byte var2 = 100;
		int var1 = var2;
		double var3 = var1;
		System.out.println(var3);
		
		//기본리터럴은 int
		char ch = (char)var2; //var2를 읽는다.
		System.out.println(ch);
		
		char ch2 = '가';
		int i = ch2;
		System.out.println("i="+i);
	}

}
