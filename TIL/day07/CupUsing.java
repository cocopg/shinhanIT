package com.shinhan.day07;

public class CupUsing {

	public static void main(String[] args) {
		print(new CoffeeCup());
		print(new WaterCup());
		print(new Cup() {
			public void use() {
				System.out.println("일회용 컵");
				
			}
		});
		print(()->System.out.println("람다표현식 구현컵"));

	}
	static void print(Cup cup) {
		cup.use();
	}

}
