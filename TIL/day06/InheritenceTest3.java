package com.shinhan.day06;

//OOP 특징: 캡슐화(정보은닉, private), 상속(기존 class 물려받음, 수정가능, 추가 가능
//			다형성(사용은 같지만 결과는 다르다)

public class InheritenceTest3 {

	public static void main(String[] args) {
		
		method4();
	}

	private static void method7() {
		//변환
		//1)객체에서 자동형변환 : 부모의 타입방 = 자식의 타입값
		Account acc = new CheckingAccount("113", "나", 2000, "66-77");
		//2)객체에서 강제형변환 : 자식의 타입방 = (자식의타입, 반드시 instance의 타입)부모의 타입값
		CheckingAccount acc2 = (CheckingAccount)acc;
	}

	private static void method6() {
		// 형변환
		// 1)자동형변환 : 큰방 = 작은방
		long bang;
		int data = 100;
		bang = data;
		// 2)강제(명시) : 작은방 = (작은방타입)큰방
		long data2 = 200;
		int bang2;
		//bang2 = data2;
	}

	static void method5(Account acc) {
		System.out.println("-----------");
		System.out.println(acc);
		System.out.println("계좌번호: "+acc.getAccountNo());
		System.out.println("예금주: "+acc.getOwnerName());
		System.out.println("잔고: "+acc.getBalance());
		
		System.out.println(acc instanceof CheckingAccount);
		if(acc instanceof CheckingAccount) {
			//부모 = 자식
			//형제로는 불가
			CheckingAccount acc2 = (CheckingAccount)acc;
			System.out.println("카드번호: "+ acc2.cardNo);
			acc2.pay("66-77", 100);
		}
		if(acc instanceof CreditLineAccount acc2) {
			System.out.println("마이너스 한도: "+ acc2.creditLine);
			int amount = acc2.withdraw(5000);
			System.out.println("출금액: "+amount);
		}
		if (acc instanceof BonusPointAccount acc3) {
			acc3.deposit(6000);
			System.out.println("보너스 포인트: "+ acc3.bonusPoint);
		}
	}

	private static void method4() {
		Account acc1 = new Account("112", "김", 1000);
		CheckingAccount acc2 = new CheckingAccount("113", "나", 2000, "66-77");
		CreditLineAccount acc3 = new CreditLineAccount("114", "왕", 3000, 2000);
		BonusPointAccount acc4 = new BonusPointAccount("114", "정", 4000, 4);

		method5(acc1);
		method5(acc2);
		method5(acc3);
		method5(acc4);

	}

	private static void method3() {
		BonusPointAccount acc1 = new BonusPointAccount("1123", "길동", 1000, 1);
		acc1.deposit(5000);
		System.out.println(acc1.getBalance());
		System.out.println(acc1.bonusPoint);

	}

	private static void method2() {
		CreditLineAccount acc2 = new CreditLineAccount("112", "현상", 2000, 1000);
		acc2.deposit(2000);
		int amount = acc2.withdraw(5000);
		System.out.println("출금액" + amount);

	}

	private static void method1() {
		CheckingAccount acc1 = new CheckingAccount("112 - 234", "홍길동", 1000, "77-88");
		acc1.deposit(2000);
		int amount = acc1.withdraw(1200);
		System.out.println("출금액: " + amount);
		System.out.println("잔고: " + acc1.getBalance());
		amount = acc1.pay("77-88", 800);
		System.out.println("카드로인출:" + amount);
	}

}
