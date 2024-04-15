package com.shinhan.day04;

public class BookMgr {
	Book1[] booklist;

	BookMgr(Book1[] booklist) {
		this.booklist = booklist;
	}

	void printBookList() {
		System.out.println("책목록");
		for (Book1 b : booklist) {
			System.out.println(b.getTitle());
		}
	}

	void printTotalPrice() {
		System.out.println("책가격 종합");
		int total = 0;
		for (Book1 b : booklist) {
			total += b.getPrice();
			System.out.println(b.getPrice());
		}
	}
}
