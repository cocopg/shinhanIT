package com.shinhan.day11.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import com.shinhan.day03.ArrayTest;
import com.shinhan.day10.thread.Account;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
class Car implements Comparable<Car> {
	String model;
	int price;

	@Override
	public int compareTo(Car obj) {
		// 가격순 asc, model desc
		if (price - obj.price == 0)
			return obj.model.compareTo(model);
		return price - obj.price;
	}

}

public class CollectionTest {

	public static void main(String[] args) {
		f10();

	}
	
	private static void f10() {
		Map<Car, Integer> data = new TreeMap<>();
		data.put(new Car("A", 10000),1);
		data.put(new Car("A", 10000),2);
		data.put(new Car("B", 30000),3);
		data.put(new Car("C", 10000),4);
		data.put(new Car("B", 30000),5);

		System.out.println(data.containsKey(new Car("C", 10000)));
		System.out.println(data.containsKey(new Car("B", 10000)));
		System.out.println(data.containsValue(4));

		for (Car key : data.keySet()) {
			System.out.println(key + "==>" + data.get(key));
		}

	}
	
	private static void f9() {
		Map<Car, Integer> data = new HashMap<>();
		data.put(new Car("A", 10000),1);
		data.put(new Car("A", 10000),2);
		data.put(new Car("B", 30000),3);
		data.put(new Car("c", 10000),4);
		data.put(new Car("B", 30000),5);

		for (Car key : data.keySet()) {
			System.out.println(key + "==>" + data.get(key));
		}

	}

	private static void f8() {
		Map<String, Car> data = new HashMap<>();
		data.put("A", new Car("A", 10000));
		data.put("A", new Car("A2", 50000));
		data.put("B", new Car("B2", 30000));
		data.put("C", new Car("c", 10000));
		data.put("B", new Car("B", 20000));

		for (String key : data.keySet()) {
			System.out.println(key + "==>" + data.get(key));
		}

	}

	private static void f7() {
		// 배열(연속공간, 갯수 가변불가)
		// List(순서있고 중복있음), Set(순서없고 중복없음), Map(키와 값의 쌍 entry)
		Set<Car> alist = new HashSet<>();
		alist.add(new Car("A", 10000));// 뒤에 추가
		alist.add(new Car("B", 20000)); // LinkedList : 배열의 원하는 위치에 삽입
		alist.add(new Car("B", 20000));// 뒤에추가
		alist.add(new Car("C", 15000));
		for (Car car : alist) {
			System.out.println(car);
		}

	}

	private static void f6() {
		// Map:Key와 value의 쌍이다.(Map.entry), key는 Set으로 만듦(중복불가)
		// 구현 class: HashMap,HashTabble, HashTable, TreeMap, Properties
		Map<String, Integer> data = new HashMap<>();
		data.put("A", 99);
		data.put("B", 100);
		data.put("C", 77);
		data.put("B", 99);
		data.put("A", 88);// 이미 존재하는 키가 있으면 덮어쓴다

		System.out.println(data.size());
		System.out.println(data.get("A"));
		System.out.println(data.get("B"));

		// 1.키의 이름을 모른다면
		System.out.println("======1.keySet()=====");
		for (String key : data.keySet()) {
			System.out.println(key + "==>" + data.get(key));
		}
		// 2.
		System.out.println("======2.entrySet()=====");
		Set<Map.Entry<String, Integer>> entrySet = data.entrySet();
		for (Entry<String, Integer> entry : data.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
		System.out.println("======3.iterator=====");
		Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + "==>" + entrySet.iterator());
		}
	}

	private static void f5() {
		// Set : 순서가없고 중복불가 interface => 구현 class : HashSet, TreeSet(순서있음)
		Set<Car> data = new TreeSet<>();
		data.add(new Car("A", 1000));
		data.add(new Car("A", 1000));
		data.add(new Car("C", 4000));
		data.add(new Car("B", 2000));
		data.add(new Car("C", 5000));

		System.out.println("개수: " + data.size());

		System.out.println("==========일반 for문 불가==========");
		System.out.println("==========향상된 for문==========");
		for (Car s : data) {
			System.out.println(s);
		}
		System.out.println("==========반복자이용(Iterator)==========");
		Iterator<Car> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	private static void f4() {
		// Set : 순서가없고 중복불가 interface => 구현 class : HashSet, TreeSet(순서있음)
		TreeSet<String> data = new TreeSet<>();
		data.add("월");
		data.add("화");
		data.add("토");
		data.add("토");
		data.add("월");
		System.out.println("개수: " + data.size());

		System.out.println("==========일반 for문 불가==========");
		System.out.println("==========향상된 for문==========");
		for (String s : data) {
			System.out.println(s);
		}
		System.out.println("==========반복자이용(Iterator)==========");
		Iterator<String> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	private static void f3() {
		// Set : 순서가없고 중복불가 interface => 구현 class : HashSet, TreeSet(순서있음)
		HashSet<String> data = new HashSet<>();
		data.add("월");
		data.add("화");
		data.add("토");
		data.add("토");
		data.add("월");
		System.out.println("개수: " + data.size());

		System.out.println("==========일반 for문 불가==========");
		System.out.println("==========향상된 for문==========");
		for (String s : data) {
			System.out.println(s);
		}
		System.out.println("==========반복자이용(Iterator)==========");
		Iterator<String> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	private static void f2() {
		// List : 순서 있고 중복가능 interface ==> 구현 class : ArrayList, LinkedList, Vector
		// ArrayList : 연속공간필요, 공간이 부족하면 자동증가, 중간 삽입, 삭제시 비효율적(당기거나 밀거나 이동이 있음)
		// LinkedList : 연속공간 불필요, 전요소나 후요소의 주소기억(공간차지), 중간 삽입, 삭제 시 효율적
		// Vector : Multi Thread에서 동기처리 가능
		List<String> data1 = new ArrayList<>();
		List<String> data2 = new LinkedList<>();
		List<String> data3 = new Vector<>();

		insertData(data1);
		insertData(data2);
		insertData(data3);

		displayData(data1, "ArrayList");
		displayData(data1, "LinkedList");
		displayData(data1, "Vector");

	}

	private static void displayData(List<String> data, String title) {
		System.out.println("==========일반 for문==========");
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
		System.out.println("==========향상된 for문==========");
		for (String s : data) {
			System.out.println(s);
		}

	}

	private static void insertData(List<String> data) {
		System.out.println("==========일반 for문==========");
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
		System.out.println("==========향상된 for문==========");
		for (String s : data) {
			System.out.println(s);

		}
	}

	private static void f1() {
		// List : 순서 있고 중복가능 interface ==> 구현 class:ArrayList, LinkedList, Vector
		ArrayList data = new ArrayList();
		data.add("문자");
		data.add(100);
		data.add(new Account());

		String a = (String) data.get(0);
		int b = (Integer) data.get(1);
		Account acc = (Account) data.get(2);
	}

}
