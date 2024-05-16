package com.shinhan.myapp.day1;

public class SamsungTV implements TV{
	
	
	public SamsungTV(String model) {
		System.out.println("SamsungTV 모델:" + model);
	}
	
	public void powerOn() {
		System.out.println(getClass().getSimpleName()+"전원을 켠다.");
	}
	public void powerOff() {
		System.out.println(getClass().getSimpleName()+"전원을 끈다.");
	}
	public SamsungTV() {
		System.out.println();
	}
}
