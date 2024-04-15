package com.shinhan.day08;

import com.shinhan.day09.Book;

public class LombokTest {

	public static void main(String[] args) {
		Book b = new Book("자바", 50000, "신용권");
		b.setPrice(30000);
		System.out.println(b);
	}
}
