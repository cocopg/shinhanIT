package com.shinhan.day02;

//자바프로그램은 class들로 이루어짐.
//하나의 .java파일에 여러 개의 class가 가능
//public class면 반드시 독립적 파일로 저장한다.

public class Review {
	
	public static void main(String args[]) {
		System.out.println("1.main시작");
		f1();
		f2();
		System.out.println("4.main끝");
	}

	private static void f2() {
		//method 내에 있는 변수는 지역변수이다.
		//변수 scope :{}내에서만 유효하다.
		int v1 = 1;
		System.out.println("v1: " + v1);
		if (true) {
			int v2 = 2;
			if (true) {
				int v3 = 2;
				System.out.println("v1: " + v1);
				System.out.println("v2: " + v2);
				System.out.println("v3: " + v3);
			}
			System.out.println("v1: " + v1);
			System.out.println("v2: " + v2);
			//System.out.println("v3: " + v3);
		}
		System.out.println("v1: " + v1);
		//System.out.println("v2: " + v2);

	}
	//1.멤버변수
	//2.생성자
	//3.메서드
	//4.block
	//5.inner class

	static void f1() {
		System.out.println("2.f1함수 시작");
		//변수:하나의 값을 저장하기 위한 기억장소이름
		//1.변수 선언: data의 성격에 따라 기본형, 참조형
		//기본형(8가지)~byte,short,char,long,int,float,doulbe,boolean
		//기본형: 값저장, 연산 비교 가능. 기능은 없다.
		//Wrapper class=> 기본형+기능추가~Byte,Short,Character,Long,Integer,Float,Doulbe,Boolean
		int var1; //=는 할당연산자
		Integer var2=100;
		//2.변수 초기화
		var1=Integer.MAX_VALUE;
		//3.변수 사용-반드시 초기화하고 사용한다.
		System.out.println(var1);
		System.out.println("3.f2함수끝 ");
		
	}

}
class Review2{
	
}
