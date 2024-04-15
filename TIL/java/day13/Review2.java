package com.shinhan.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Member2 {
	private String name;
	private String job;

	public Member2(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}
	@Override
	public String toString() {
	 return "{name:" + name + ", job:" + job + "}";
	}
}

class Member {
	private String name;
	private int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

public class Review2 {

	public static void main(String[] args) {
		f6();
	}

	private static void f6() {
		List<Member2> list = Arrays.asList(
				 new Member2("홍길동", "개발자"),
				 new Member2("김나리", "디자이너"),
				 new Member2("신용권", "개발자")
				 );
		Map<String, List<Member2>> groupingMap =
				list.stream().collect(Collectors.groupingBy(m->m.getJob()));
		groupingMap.get("개발자").stream().forEach(m->System.out.println(m));;
		
	}

	private static void f5() {
		List<Member2> list = Arrays.asList(new Member2("홍길동", "개발자"), new Member2("김나리", "디자이너"),
				new Member2("신용권", "개발자"));

		List<Member2> developers = list.stream()
				.filter(m -> m.getJob().equals("개발자"))
				.toList();
		List<Member2> developers2 = list.stream()
				.filter(m->m.getJob().equals("개발자")).collect(Collectors.toList());

		developers2.stream().forEach(m -> System.out.println(m.getName()));
		developers.stream().forEach(m -> System.out.println(m.getName()));
	}

	private static void f4() {
		// List<Member> list = new ArrayList<Member>();
		List<Member> list = Arrays.asList(new Member("홍길동", 30), new Member("신용권", 40), new Member("감자바", 26));
		double avg = list.stream().mapToInt(i -> i.getAge()).average().getAsDouble();
		// double avg = list.stream().mapToInt(i->i.getAge()).average().orElse(0);
		list.stream().mapToInt(i -> i.getAge()).average().ifPresentOrElse(a -> {
			System.out.println("있음 avg = " + a);
		}, () -> {
			System.out.println("data가 없음");
		});

		System.out.println("평균 나이: " + avg);
	}

	private static void f3() {
		List<String> list = Arrays.asList("This is a java book", "Lambda Expressions",
				"Java8 supports lambda expressions");
		list.stream().filter(line -> line.toLowerCase().contains("java")).forEach(s -> System.out.println(s));
	}

	private static void f2() {
		int[] arr = { 1, 2, 3, 4, 5 };
		// 내부반복자(stream)
		System.out.println("-------------forEach는 최종단계-------------");
		Arrays.stream(arr).forEach(i -> System.out.println(i));
		System.out.println("-----peek는 중간단계, 멈추면 결과 볼 수 없음-----");
		long result = Arrays.stream(arr).peek(i -> System.out.println(i)).sum();
		System.out.println("sum: " + result);

	}

	private static void f1() {
		int[] arr = { 1, 2, 3, 4, 5 };
		// 향상 for: 외부반복자(Iterator)
		for (int i : arr) {
			System.out.println(i);
		}

	}

}
