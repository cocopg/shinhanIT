package com.shinhan.day06.lab;

public abstract class Machine {

	void powerOn() {
	}

	void powerOff() {
	}

	abstract void work();

}

class Computer extends Machine {
	public void work() {
		System.out.println();
	}

}
