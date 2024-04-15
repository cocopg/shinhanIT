package com.shinhan.day04;

//class:틀, 특징, 행위를 정한다.
//object: 각각의 다른 object와 구별되는 독립된 특징을 부여한다.

public class Korean {

	// field
	private String nation = "대한민국";
	private String name;
	private String ssn;

	// 2.constructor :목적이 초기화이다.
	Korean(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}

	Korean(String name) {
		this.name = name;
	}

	// 3.메서드(기능):return type 필수
	void print() {
		System.out.println(nation);
		System.out.println(name);
		System.out.println(ssn);
	}

	@Override
	public String toString() {
		return "Korean[nation=" + nation + ", name" + name + ", ssn" + ssn + "]";
	}

}
