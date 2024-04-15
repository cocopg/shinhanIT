package com.shinhan.day04;

public class Car {
	// 1.field(특징, 변수, data저장, 멤버변수)
	// 접근지정자가(Modifier) private인 경우 외부에서 접근 불가하다.
	// 접근하고자 한다면 기능이 추가되어야 한다.
	//읽기:getter, 쓰기:setter
	// JavaBeans기술의 규칙:setCompany, getCompany...
	private String company = "현대자동차";
	private String model;
	private String color;
	private int maxSpeed;
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	// 2.constructor(생성자)...생성자는 여러가지 방법을 정의(overloading)
	Car() {
		System.out.println("default생성자...arg없음");
	}

	Car(String model, String color, int maxSpeed) {
		// super(); 부모생성된다
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;

	}

	Car(String model, int maxSpeed, String color) {
		this(model, color, maxSpeed);// 생성자 호출은 첫번째 줄에만 사용가능, super()부분이 수행안함
	}

	Car(int maxSpeed, String color) {
		this("Genesis", color, maxSpeed);// 모르면 null
	}

	Car(String model) {
		this(model, "white", 0);
	}

	String first;// 멤버변수...new 시에 자동으로 초기화됨
	
	// 3.메서드, return타입이 반드시 필요, 없으면 void

	String carInfoPrint(String title) {
		String second = null;// 지역변수...반드시 초기화하고 사용
		System.out.println(title);
		System.out.println("=======Car의 정보=======");
		System.out.println("제조사:" + company);
		System.out.println("모델:" + model);
		System.out.println("컬러:" + color);
		System.out.println("최고속력:" + maxSpeed);
		System.out.println("second:" + second);
		powerOn();
		return "=======끝=======";
	}
	void powerOn() {
		System.out.println("=====powerOn=====");
	}
	
}
