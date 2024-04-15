package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	String accountNo;
	String ownerName;
	int balance;
	
	public void deposit(int amount) {
		balance +=  amount;
	}
	int withdraw(int amount) {
		if(balance >= amount) {
			balance -=  amount;
			return amount;			
		}else {
			System.out.println("잔고부족");
			return 0;
		}
	}
}
