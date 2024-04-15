package com.shinhan.day04;
//source-generate getter and setter - 자동 getter/setter만들기
//source-generate constructor using field - 자동 생성자 만드기
public class Book1 {
	private String title;
	private int price;
	
	public Book1(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
}
