package com.shinhan.day04;

public class NoteBook {
	// 1.field: object마다 각각의 값을 저장하기 위함.
	// field:non-static(instance 변수)->반드시 생성 후 사용가능
	//       static(class변수, 공유변수)->객체생성과 무관하다.
	private String model;
	private int price;

	//
	static int count;

	// 2.constructor: 값 초기화
	public NoteBook(String model, int price) {
		super();
		this.model = model;
		this.price = price;
		count++;
	}
	// 일반메서드
	// getter(얻기) / setter(변경)

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
