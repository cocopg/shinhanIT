package com.shinhan.day05;

public class ShopService {
	// 생성자의 접근지정자를 private
	private ShopService shop;

	private ShopService() {

	}

	public ShopService getInstance() {
		if (shop == null)
			shop = new ShopService();
		return shop;
	}
}
