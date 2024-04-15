package com.shinhan.day04;

public class Employee2 {
	String id;
	String name;
	int baseSalary;
	
	public Employee2(String id, String name, int baseSalary) {
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	double getSalary(double bonus) {
		return baseSalary + baseSalary * bonus; 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	//부모가 물려준 함수를 재정의 : Override라고 한다.
	//이름 같고 매개변수 같고 return같고 접근제한자가 같거나 더 넓어져야 한다.
	public String toString() {
		return name
				+ "("
				+ id
				+ ") 사원의 기본급은 "
				+ baseSalary
				+ "원 입니다.";
	}
	String toString2() {
		return "name(id) 사원의 기본급은 baseSalary원 입니다.";
	}
	
}
