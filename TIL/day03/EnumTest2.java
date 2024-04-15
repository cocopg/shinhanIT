package com.shinhan.day03;

import java.util.Calendar;
import java.util.Scanner;

public class EnumTest2 {
	final static String SUCCESS = "성공";
	final static String FAIL = "실패";

	public static void main(String[] args) {
		// loginCheck();
		getWeek();

	}

	private static void getWeek() {
		Calendar cal = Calendar.getInstance();
		// System.out.println(cal);
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1;// 0~11월
		int ww = cal.get(Calendar.DAY_OF_WEEK);
		int dd = cal.get(Calendar.DATE);
		System.out.println("년도:" + yy);
		System.out.println("월:" + mm);
		System.out.println("주:" + ww);
		System.out.println("일:" + dd);
		Week week = null;
		switch (ww) {
		case 1:
			week = Week.SUNDAY;
			break;
		case 2:
			week = Week.MONDAY;
			break;
		case 3:
			week = Week.TUESDAY;
			break;
		case 4:
			week = Week.WEDNSDAY;
			break;
		case 5:
			week = Week.THURSDAY;
			break;
		case 6:
			week = Week.FRIDAY;
			break;
		case 7:
			week = Week.SATURDAY;
			break;
		}
		System.out.println(week);
	}

	private static void loginCheck() {
		Work result;
		Scanner sc = new Scanner(System.in);
		System.out.print("ID PW>>");
		String id = sc.next();
		String pw = sc.next();
		if (id.equals("firstzone") && pw.equals("1234")) {
			result = Work.SUCCESS;
		} else {
			result = Work.FAIL;
		}
		System.out.println(result);
		sc.close();
	}
}
