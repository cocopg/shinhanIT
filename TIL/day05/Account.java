package com.shinhan.day05;

public class Account {
	private int balance;
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	public Account(String accNum, String accNm, int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		if(balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
			this.balance = balance;
		} else {
			System.out.println("잔액은 " + MIN_BALANCE + "에서 " + MAX_BALANCE + " 사이어야 합니다.");
		}
	}

	public static void main(String[] args) {
		Account account = new Account("123456", "John Doe", 0);
		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance());
		account.setBalance(-100); // 최소 잔액 미달 오류 출력
		System.out.println("현재 잔고: " + account.getBalance()); // 잔액 변동 없음
		account.setBalance(2000000); // 최대 잔액 초과 오류 출력
		System.out.println("현재 잔고: " + account.getBalance()); // 잔액 변동 없음
		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance());
	}
}
