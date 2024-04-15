package com.shinhan.day04;

//class: object를 만들기 위한 틀
//object: class를 이용해서 만든 독립된 실체(instance)
public class Book {

	// 1.field(변수, data저장목적)
	String title;
	int price;

	// 2.constructor(생성자메서드):argument가 없는 기본 생성자는 컴파일시에 만들어진다.
	// calss 이름과 같아야 한다. return 불가
	// 생성자 추가 가능 - 추가하면 컴파일시에 생성자를 만들지 않는다.
	// Overloading(이름은 같고 매개변수 사양이 다르다)
	//this:현재객체
	//매개변수이름과 field이름이 충돌발생시 구분하기 위해 사용한다.
	//같은 이름의 다른 모양의 생성자를 호출하기: this()
	Book() {
		this(null,0);
	}

	Book(String title, int price) {
		System.out.println("argument 2개 생성자");
		this.title = title;
		this.price = price;
	}
	Book(String title) {
		this(title,50000);
	}
	Book(int price) {
		this("제목모름",price);
	}
	// 3.method(함수,기능): 반드시 return type을 정의한다. return값이 없으면 void
	void bookInfoPrint(){
		System.out.println("==책의정보==");
		System.out.println("제목:" + title);
		System.out.println("가격:" + price);
	}
	// 4.block
	{
		System.out.println("block==object생성시마다 수행");
	}
	static {
		System.out.println("class load시에 1회 수행");
	}
	// 5.inner class
	class AA{
		
	}
}
class BB{
	
}
