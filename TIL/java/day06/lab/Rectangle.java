package com.shinhan.day06.lab;

public class Rectangle extends Shape{
	double length, width;
	
	public Rectangle(String color, double length, double width) {
		super(color, "Rectangle");
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double calculatePerimeter() {
		
		return length*width;
	}



	@Override
	public double calculateArea() {
		return 2*length + 2*width;
	}



	

}
