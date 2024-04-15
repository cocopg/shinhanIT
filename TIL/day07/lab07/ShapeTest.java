package com.shinhan.day07.lab07;

public class ShapeTest {

	public static void main(String[] args) {
		Shape[] arr = new Shape[2];
		arr[0] = new Rectangle(5,6);
		arr[1] = new RectTriangle(6,2);
		
		for(Shape shape:arr) {
			System.out.println("area: "+ shape.getArea());
			System.out.println("perimeter: "+ shape.getPerimeter());
			if(shape instanceof Resizable r) {
				System.out.println("new area: "+ shape.getArea());
				System.out.println("new perimeter: "+ shape.getPerimeter());
				
			}
		}
		

	}

}
