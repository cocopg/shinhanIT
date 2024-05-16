package com.shinhan.myapp.day1;

public class LgTV implements TV{
	public LgTV() {
		System.out.println("LGTV생성자");
	}
	
	public void powerOn() {
		System.out.println("****LG**POWERON****");
		System.out.println(getClass().getSimpleName()+"전원을 켠다.");
	}
	public void powerOff() {
		System.out.println("****LG**POWEROFF****");
		System.out.println(getClass().getSimpleName()+"전원을 끈다.");
	}

}
