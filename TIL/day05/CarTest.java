package com.shinhan.day05;

public class CarTest {

	public static void main(String[] args) {
		method3();

	}

	private static void method3() {
		System.out.println("Car 대수: "+ Car.carCount);
		System.out.println("Car 회사: "+ Car.company);
		//배열변수를 선언+생성
		Car[] arr = new Car[5];
		//1.객체참조변수 선언 + 선언 + 사용
		arr[0] = new Car("A모델", 1000);
		arr[1] = new Car("B모델", 2000);
		arr[2] = new Car("C모델", 3000);
		arr[3] = new Car("D모델", 3000);
		arr[4] = new Car(5000);
		System.out.println("생성 Car 대수: "+ Car.carCount);
		
		for(Car cc:arr) {
			cc.carInfoPrint("-------");
		}
		
		
	}

	private static void method2() {

		System.out.println("-------");
		
	}

	private static void method1() {
		//static은 class소유이므로 object생성과 관계없다.
		System.out.println("Car 대수: "+ Car.carCount);
		System.out.println("Car 회사: "+ Car.company);
		Car.carInfoPrint2("******");
	}

}
