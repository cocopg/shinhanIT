package com.shinhan.day07.lab07;

public class Rectangle extends Shape implements Resizable {

	double width;
	double height;

	public Rectangle(double width, double height) {
		super(3);
		this.width = width;
		this.height = height;
	}

	@Override
	public void resize(double s) {
		width = width * s;
		height = height * s;

	}

	@Override
	double getArea() {
		return width * height;
	}

	@Override
	double getPerimeter() {
		return 2 * (width + height);
	}

}
