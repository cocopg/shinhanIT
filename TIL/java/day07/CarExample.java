package com.shinhan.day07;

class Car{
	class Tire{}
	static class Engine{}
	
	void method() {
		class Chair{
			void f1() {}
		}
		Chair cc = new Chair();
		cc.f1();
	}
}

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		//인스턴스 inner class
		Car.Tire tire = myCar.new Tire();
		//static inner class
		Car.Engine engine = new Car.Engine();
		//local class는 메서드 내에서 접근, 외부접근 불가
		myCar.method();

	}

}
