package com.shinhan.day10;

public class CoffeeAgency implements Rentable<CoffeeMachine> {

	@Override
	public CoffeeMachine rent() {
		return new CoffeeMachine();
	}
	
}
