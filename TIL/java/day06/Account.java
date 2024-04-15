package com.shinhan.day06;
//extends Object는 생략되어있음.
//JavaBeans기술 규격서 : field는 접근제한자를 private, 외부에서는 getter/setter접근

//final : 최종을 의미
//final class : 상속 불가
//final field : 1회만 할당, 수정불가
//final static field : 상수(1회 할당, 선언시 또는 static block)
//final method : 재정의 불가
public class Account extends Object{
	
	private final String name = "우리은행";
	private final String name2;
	private static final String NAME3 = "우리은행";
	private static final String NAME4;
	static {
		NAME4 = "농협은행";
	}
	final void method1() {
		System.out.println("자식이 재정이 불가하다.");
	}
	
	private String accountNo;
	private String ownerName;
	private int balance;
	

//생성사: 정의하지 않으면 컴파일러가 default생성자를 만듬.정의되면 안만듬
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		name2 = "신한은행";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount){
		if (balance < amount) {
			System.out.println("잔고부족. 출금불가");
			return 0;
		}
			//throw new Exception("잔액이 부족합니다.");
		balance -= amount;
		return amount;
	}
	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	

}
