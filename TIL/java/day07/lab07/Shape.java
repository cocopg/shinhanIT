package com.shinhan.day07.lab07;

public abstract class Shape {

	int numSides;
	
	Shape (int numSides){
		this.numSides = numSides;
	}
	
	int getNumSides() {
		return numSides;
	}
	
	
	abstract double getArea();
	
	abstract double getPerimeter();

	
}
