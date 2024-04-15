package com.shinhan.day09;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import com.shinhan.util.DateUtil;

public class ObjectTest3 {

	public static void main(String[] args) {
		f8();

	}

	private static void f8() {
		java.util.Date d = new java.util.Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println(sdf.format(d));

		// 문자->날짜
		String s = "2024-03-22";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

		try {
			java.util.Date d2 = sdf2.parse(s);
			java.sql.Date d3 = new java.sql.Date(d2.getTime());
			System.out.println(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(DateUtil.getUtilDate(s));
		System.out.println(DateUtil.getSQLDate(s));
	}

	private static void f7() {
		int a = 1234567890;
		DecimalFormat format = new DecimalFormat("###,###,###");
		

	}

	private static void f6() {

		LocalDateTime d = LocalDateTime.now();
		LocalDate d2 = LocalDate.now();

		System.out.println(d);
		System.out.println(d2);

		System.out.println(d.getYear());
		System.out.println(d.getMonth());
		System.out.println(d.getDayOfMonth());
		System.out.println(d.getHour());
		System.out.println(d.getDayOfWeek());

	}

	private static void f5() {

		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.HOUR));

	}

	private static void f4() {

		Date d1 = new Date();
		java.util.Date d2 = new java.util.Date();

		System.out.println(d2);
		System.out.println(1900 + d2.getYear());
		System.out.println(d2.getTime());

		java.sql.Date d3 = new java.sql.Date(d2.getTime());
		java.sql.Date d4 = new java.sql.Date(2024 - 1900, 2, 22);

		System.out.println(d3);
		System.out.println(d4);
	}

	private static void f3() {
		double a = 5.1;
		System.out.println(Math.ceil(a));
		System.out.println(Math.floor(a));
		System.out.println(Math.round(a));

	}

	private static void f2() {
		String s = "100";
		String s2 = "100.456";
		int b = Integer.parseInt(s);
		double d = Double.parseDouble(s2);

	}

	private static void f1() {
		Integer a = 100;// Auto Boxing
		// Integer a = new Integer(100);

		// int b = a.intValue() + 200; // UnBoxing
		int b = a + 200;
	}

}
