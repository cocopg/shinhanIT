package com.shinhan.day06.lab;

class Parent {
	public String name;

	public Parent(String name) {
		this.name = name;
	}
}
class Child extends Parent{
	public int studentNo;
	
	public Child(String name, int studentNo) {
		super(name);
		this.studentNo = studentNo;
	}
}
