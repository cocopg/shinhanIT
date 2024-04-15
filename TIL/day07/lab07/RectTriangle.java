package com.shinhan.day07.lab07;

public class RectTriangle extends Shape {

	double width;
	double height;

	public RectTriangle(double width, double height) {
		super(3);
		this.width = width;
		this.height = height;
	}

	double getArea() {
		return width * height / 2;
	}

	double getPerimeter() {
		return width + height + Math.sqrt((height * height + width * width));

	}

}
