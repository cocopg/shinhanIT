package com.shinhan.day04;

public class Book1Test {

	public static void main(String[] args) {
		Book1[] b = new Book1[5];
		b[0] = new Book1("Java Program",30000);
		b[1] = new Book1("JSP Program",25000);
		b[2] = new Book1("SQL Fundamentals",20000);
		b[3] = new Book1("JDBC Program",32000);
		b[4] = new Book1("EJB Program",25000);
		
		BookMgr bm = new BookMgr(b);
		bm.printBookList();
		bm.printTotalPrice();


	}

}
