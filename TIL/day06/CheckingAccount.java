package com.shinhan.day06;

public class CheckingAccount extends Account {
	// 1. 상속후 field추가
	String cardNo;

	// 2. 생성자 정의...부모의 생성자를 명시적으로 호출
	// 부모의 field가 private로 되어있는 경우
	// 자식은 값을 setting하기위해 1)생성자이용 2)setter이용
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		// 생성자호출: 자동으로 super();
		// 생성자호출: 명시적으로 호출하기
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}

	// 3. 상속 후 가능추가...카드번호가 같으면 인출하기
	int pay(String cardNo, int amount) {
		if (cardNo.equals(this.cardNo)) {
			return withdraw(amount);
		} else {
			System.out.println("카드번호 불일치. 인출불가");
			return 0;
		}

		
	}
	@Override
	public String toString() {
		return "CheckingAccount [cardNo=" + cardNo + "]";
	}

	

}
