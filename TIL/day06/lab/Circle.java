package com.shinhan.day06.lab;

public class Circle extends Shape {

	double radius;
	double circumference;

	public Circle(String color, double radius, double circumference) {
		super(color, "Circle");
		this.radius = radius;
		this.circumference = circumference;
	}


	public Circle(String string, int i) {
		
	}


	public double getRadius() {
		return radius;
	}

	@Override
	public double calculateArea() {
		
		return radius*radius*Math.PI;
	}

	@Override
	public double calculatePerimeter() {
		circumference = 2*Math.PI * radius;
		return circumference;
	}

}
