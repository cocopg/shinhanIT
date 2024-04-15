package com.shinhan.day08.lab;

class CellPhone {
	String model;
	double battery;

	CellPhone(String model) {
		this.model = model;
	}

	void call(int time) {
		if (time < 0)
			throw new IllegalArgumentException("통화시간 입력오류");
		System.out.printf("통화시간 :%d분\n", time);
		battery -= time * 0.5;
		if (battery < 0)
			battery = 0;
	}

	void charge(int time) {
		if (time < 0)
			throw new IllegalArgumentException("충전시간 입력오류");
		System.out.printf("충전시간 :%d분\n", time);
		battery += time * 3;
		if (battery > 100)
			battery = 100;
	}

	void printBattery() {
		System.out.printf("남은 배터리 양 : %4.1f\n", battery);
	}
	public boolean equals(Object otherObject) {
		if(!(otherObject instanceof CellPhone))return false;
		CellPhone phone = (CellPhone)otherObject;
		return model.equals(phone.model);
		
	}

}

public class CellPhoneMain {

	public static void main(String[] args) {
		CellPhone myPhone = new CellPhone("SCH-600");

		myPhone.charge(20); // 20분간 충전을 한다.
		myPhone.printBattery();

		myPhone.call(300); // 300분간 통화를 한다.
		myPhone.printBattery();

		myPhone.charge(50); // 50분간 충전을 한다.
		myPhone.printBattery();

		myPhone.call(40); // 40분간 통화를 한다.
		myPhone.printBattery();

		try {
			myPhone.call(-20); // 통화시간이 잘못 입력되었다.
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		CellPhone yourPhone = new CellPhone("SCH-600");

		if (myPhone.equals(yourPhone)) {
			System.out.println("동일 모델입니다.");
		} else {
			System.out.println("다른 모델입니다.");
		}

	}

}
