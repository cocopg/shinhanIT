package com.shinhan.day10;

import java.util.Arrays;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString

class Student implements Comparable<Student> {
	String name;
	int score;

	@Override
	public int compareTo(Student obj) {
		// 점수로desc,같은점수는 이름으로 asc
		if (obj.score == score)
			return name.compareTo(obj.name);
		return obj.score - score;
		// return name.compareTo(obj.name) * (-1);
		// return name.compareTo(obj.name);
		// return obj.score - score;
	}
}

public class GenericTest2 {
	public static void main(String[] args) {
		f5();
	}

	private static void f5() {
		Car[] arr = { new Car("A", 100, "black"), new Car("C", 700, "black"), new Car("F", 100, "white"),
				new Car("F", 300, "red"), new Car("D", 310, "blue"), };
		print2(arr, "original");
		Arrays.sort(arr);
		print2(arr, "모델명 Descending, 가격 Descending, 컬러 Ascending");

		// 가격 asc
		Arrays.sort(arr, (Car o1, Car o2) -> {
			int result =  o1.price - o2.price;
			if(result == 0) {
				int result2 =  o2.model.compareTo(o1.model);
				if(result == 0)return o2.color.compareTo(o1.color);
				return result2;
				}
			return result;
		});
		print2(arr, "가격 asc");

	}

	private static void print2(Car[] arr, String title) {
		System.out.println("=**=" + title + "=**=");
		for (Car car : arr) {
			System.out.println(car);
		}
	}

	private static void f4() {
		Student[] arr = { new Student("A", 10), new Student("C", 20), new Student("B", 20), new Student("D", 40),
				new Student("E", 50) };
		print(arr, "score Ascending");
		// Comparable interface를 구현해야 Sort가능하다.
		Arrays.sort(arr);
		print(arr, "score Descending, 이름 Ascending");
		// 이미구현 Sort기준을 변경
		Arrays.sort(arr, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// 이름으로 desc, 점수 asc
				int result = o2.name.compareTo(o1.name);
				if (result == 0)
					return o1.score - o2.score;
				return result;
			}
		});
		print(arr, "이름 Descending, 점수 Ascending");

		Arrays.sort(arr, (o1, o2) -> {
			int result = o1.name.compareTo(o2.name);
			if (result == 0)
				return o2.score - o1.score;
			return result;

		});
		print(arr, "이름 Ascending, 점수 Descending");
	}

	static void print(Student[] arr, String title) {
		System.out.println("====" + title + "====");
		for (Student st : arr) {
			System.out.println(st);
		}
	}

	private static void f3() {
		// TODO Auto-generated method stub

	}

	private static void f2() {
		String[] arr = { "Coffee", "Aavatar", "yOu", "Apple", "airplane" };
		System.out.println("original:" + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Asending Sort:" + Arrays.toString(arr));
		/*
		 * 2.익명구현클래스 Arrays.sort(arr, new Comparator<String>() {
		 * 
		 * @Override public int compare(String o1, String o2) { return
		 * o2.compareToIgnoreCase(o1); } });
		 * System.out.println("Descending Sort:"+Arrays.toString(arr));
		 */
		// 3.람다표현식
		// Arrays.sort(arr, (String o1, String o2)->o2.Compa);
	}

	private static void f1() {
		Integer[] arr = { 100, 96, 21, 66, 71, 81 };
		System.out.println("original:" + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Asending Sort:" + Arrays.toString(arr));

		// discending Sort
		// 1.구현클래스
		Arrays.sort(arr, new MyDescendingSort());
		// 2.익명클래스
		/*
		 * Arrays.sort(arr, new Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { return o2-o1; } });
		 */

		// 3.람다표현식
		Arrays.sort(arr, (o1, o2) -> o2 - o1);
		System.out.println("Descending Sort:" + Arrays.toString(arr));
	}

}
