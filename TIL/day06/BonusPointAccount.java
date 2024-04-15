package com.shinhan.day06;

public class BonusPointAccount extends Account {
	//field추가
	int bonusPoint;
	
	//생성자 정의
	public BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}
	//메서드 재정의(override)
	@Override
	void deposit(int amount) {
		super.deposit(amount);
		bonusPoint+=amount *0.001; //복합대입연산자는 자동형변환됨
		//bonusPoint = (int)(bonusPoint + amount*0.001);
	}
	@Override
	public String toString() {
		return "BonusPointAccount [bonusPoint=" + bonusPoint + "]";
	}
	
	
	
}
