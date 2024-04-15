package com.shinhan.day09.lab;

import java.util.HashSet;

public class StudentExample {
	public static void main(String[] args) {
		// Student를 저장하는 HashSet 생성 - 중복불가
		HashSet<Student> hashSet = new HashSet<Student>();
		HashSet<StudentVO> hashSet2 = new HashSet<StudentVO>();
		HashSet<StudentRecord> hashSet3 = new HashSet<StudentRecord>();

		// Student 저장
		hashSet.add(new Student("1"));
		hashSet.add(new Student("1")); // 같은 학번이므로 중복 저장이 안됨
		hashSet.add(new Student("2"));
		
		hashSet2.add(new StudentVO("1"));
		hashSet2.add(new StudentVO("1")); // 같은 학번이므로 중복 저장이 안됨
		hashSet2.add(new StudentVO("2"));
		
		hashSet3.add(new StudentRecord("1"));
		hashSet3.add(new StudentRecord("1")); // 같은 학번이므로 중복 저장이 안됨
		hashSet3.add(new StudentRecord("2"));

		// 저장된 Student 수 출력
		System.out.println("저장된 Student 수: " + hashSet.size());
		System.out.println("저장된 Student 수: " + hashSet2.size());
		System.out.println("저장된 Student 수: " + hashSet3.size());
	}
}
