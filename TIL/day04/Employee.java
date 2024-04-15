package com.shinhan.day04;

public class Employee {

	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;

	public Employee(String name, String title, int baseSalary) {
		this.name = name;
		this.title = title;
		this.baseSalary = baseSalary;
		getTotalSalary();
	}

	public void getTotalSalary() {
		if (title == "부장") {
			totalSalary = (int)(baseSalary + baseSalary * 0.25);
		} else if (title == "과장") {
			totalSalary = (int)(baseSalary + baseSalary * 0.15);
		} else {
			totalSalary = (int)(baseSalary + baseSalary * 0.05);
		}
		return;
	}

	public void print() {
		System.out.println(title + "직급의" + name + "씨의 본봉은" + baseSalary
				+ "원이고 총 급여는" + totalSalary + "원입니다.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}
}
