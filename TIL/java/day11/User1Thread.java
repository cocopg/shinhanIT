package com.shinhan.day11;

public class User1Thread extends Thread {
	
	private Calculator calculator;
	
	User1Thread(){
		setName("User1쓰레드");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory(100);
	}
	

}
