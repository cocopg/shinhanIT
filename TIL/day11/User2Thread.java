package com.shinhan.day11;

public class User2Thread extends Thread {
	
	private Calculator calculator;
	
	User2Thread(){
		setName("User2쓰레드");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory(50);
	}
	

}
