package com.shinhan.day10.lab;

public class Course {

	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	//student,person, object
	public static void registerCourse3(Applicant<? super Student> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	//worker,person,object
	public static void registerCourse4(Applicant<? super Worker> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
}
