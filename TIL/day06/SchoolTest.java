package com.shinhan.day06;

public class SchoolTest {
	
	public class Student {
		private String name;
		private int age;
		private int id;

		Student(String name, int age, int id) {
			this.name = name;
			this.age = age;
			this.id = id;
			print();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		private void print() {
			System.out.println("이름: " + name + "나이: " + age  + "학번: " + id);

		}
	}
}