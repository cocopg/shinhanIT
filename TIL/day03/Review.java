package com.shinhan.day03;

public class Review {

	public static void main(String[] args) {
		call(100);
		call(55);
		call2(27);
		call2(32);
		call3(100);
		call4(11);
		call5(10);

	}
	
	private static void call5(int a) {
		//반복문do~while : 1~a까지 합계구하기
		int total=0;
		int i=1;
		do {
			if(i==1)break;
			total+=i++;
			//i++;
		}while(i<=a);
		System.out.println(total);
	}
	
	private static void call4(int a) {
		//반복문while : 1~a까지 합계구하기
		int total=0;
		int i=1;
		while(i<=a) {
			total+=i++;
			//i++;
		}
		System.out.println(total);
	}
	
	private static void call3(int a) {
		//반복문for : 1~a까지 합계구하기
		int total=0;
		for(int i=1;i<=a;i++) {
			total+=i;
		}
		System.out.println(total);
	}

	private static void call2(int a) {
		// 조건문 switch
		switch (a % 2) {
		case 0:
			System.out.println(a + " =짝수");
			break;
		default:
			System.out.println(a + " =홀수");
		}
	}

	// 반복사용
	private static void call(int a) {
		// 조건문 if
		if (a % 2 == 0) {
			System.out.println(a + " =짝수");
		} else {
			System.out.println(a + " =홀수");
		}
		System.out.println(a % 2 == 0 ? a + "짝수" : a + "홀수");

	}

}
