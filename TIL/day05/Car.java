package com.shinhan.day05;

//class : object를 만들기 위한 툴
//object : class를 이용해서 만든 독립된 개체
//instance == object, new로 만ㄷㄴ 실체

public class Car {
	// 1. field(특징, 데이터값 저장, 변수):static(class변수, object들의 공통변수)
	// non-static(instance변수, 멤버변수), new시에 자동으로 초기화된다.
	static String company = "현대자동차"; // class가 load시에 값이 할당된다.
	static int carCount;
	private String model;
	int price;

	// 2. constructor (생성사메서드)... 컴파일시에 정의가 없으면 자동으로 default 생성자(arg없음)를 만들어준다.
	// 객체생성시 자동으로 호출된다. new Car();
	// 생성자는 생성 시 값 초기화가 목적이다.
	// 매개변수 이름과 멤버변수 이름이 충돌발생, 이를 구분하기 위해 현재 객체를 this라고 사용한다.
	// 생성사의 overloading(이름이 같고 매개변수 사양이 다르다)
	// 하나의 생성자가 같은 이름의 다른 모양의 생성자를 호출 시 사용한다. this()
	Car(String model, int price) {
		// 함수이름(변수타입 매개변수) : 매개변수는 지역변수
		this.model = model;
		this.price = price;
		carCount++;
		System.out.println(carCount + "번째 자동차가 만들어집니다.");
	}

	Car(String model) {
		// 함수이름(변수타입 매개변수) : 매개변수는 지역변수
		this(model, 1000);
	}

	Car(int price) {
		// 함수이름(변수타입 매개변수) : 매개변수는 지역변수
		this("Genesis", price);
	}

	// 3. 일반 method(기능구현, 문장들의 묶음), 반드시 return값의 타입을 정의한다. 없으면 void
	void carInfoPrint(String title) {
		System.out.println(title);
		System.out.println("company: " + company);
		System.out.println("carCount: " + carCount);
		System.out.println("model: " + model);
		System.out.println("price: " + price);
	}
	
	//getter / settet는 이름규칙을 지킨다. JavaBeans기술에서 사용하기 떄문
	String getModel() {
		return model;
	}
	
	public static String getCompany() {
		return company;
	}

	public static void setCompany(String company) {
		Car.company = company;
	}

	int getPrice() {
		return price;
	}
	void setModel(String model){
		this.model = model;
	}
	void setPrice(int price) {
		this.price=price;
	}
	
	static void carInfoPrint2(String title) {
		System.out.println(title);
		System.out.println("company: " + company);
		System.out.println("carCount: " + carCount);
		//사용이 불가(static method에서 non-static(instance변수) 사용불가
		//System.out.println("model: " + model);
		//System.out.println("price: " + price);
	}
	// 4. block
	{
		System.out.println("----instance block(객체생성시마다 수행)----");
	}
	static {
		System.out.println("----class load시 1회 수행----");		
		//class load시 static변수 로직이 필요한 초기화시 사용한다.
	}
	// 5. inner class
	class Tire{
		//1.field
		String color;
		//2.constructor
		//3.method
		//4.block
		//5.inner class
	}
}
