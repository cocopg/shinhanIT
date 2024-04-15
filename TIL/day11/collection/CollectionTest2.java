package com.shinhan.day11.collection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionTest2 {
	// Map(키, 값, 쌍) 키 중복불가, hashcode(),equals()
	// : HashMap, TreeMap(순서있음, Comparable구현)
	// Hashtable (동기화가능)
	public static void main(String[] args) {

		f7();

	}

	private static void f7() {
		String[] arr= {"자바","디비","웹","프레임워크"};
		List<String>alist = Arrays.asList(arr);
		List<String> alist2 = List.of("자바","디비","웹","프레임워크");
		Set<String> aset = Set.of("자바","디비","웹","프레임워크");//중복 data는 불가
		Map<Integer, String> map = Map.of(1,"자바",2,"디비",3,"웹",4,"프레임워크");
		

		List<String>alist3 = new ArrayList<String>();
		alist3.add("A1");
		alist3.add("A2");
		alist3.add("A3");
		List<String>alist4 = List.copyOf(alist3);
		
		
		//alist.add("AAAA");
		//alist2.add("AAAA");
		for(Integer key:map.keySet()) {
			System.out.println(key+"=="+map.get(key));
		}
		
	}

	// Queue :
	private static void f6() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(100);
		queue.offer(300);
		queue.offer(400);
		queue.offer(500);
		queue.offer(200);
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

	private static void f5() {
		// stack : LIFO
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(100);
		stack.push(300);
		stack.push(400);
		stack.push(200);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

	private static void f4() {
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("appel1", 110);
		treeMap.put("appel2", 120);
		treeMap.put("appel3", 130);
		treeMap.put("appel4", 140);
		treeMap.put("appel5", 150);
		print(treeMap, "original");
		print2(treeMap, "original");
		print3(treeMap, "찾기");
		NavigableMap<String, Integer> datas = treeMap.descendingMap();
		for (String key : datas.keySet()) {
			System.out.println(key + "==>" + treeMap.get(key));
		}

	}

	private static void print3(TreeMap<String, Integer> treeMap, String title) {
		System.out.println("====" + title);
		System.out.println(treeMap.firstKey());
		System.out.println(treeMap.firstEntry());

	}

	private static void print2(TreeMap<String, Integer> treeMap, String title) {
		System.out.println("===========" + title);
		for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}

	}

	private static void print(TreeMap<String, Integer> treeMap, String title) {
		for (String key : treeMap.keySet()) {
			System.out.println(key + "==>" + treeMap.get(key));
		}

	}

	private static void f3() {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		print(scores, "ascending");
		// print2(scores);
		// NavigableSet<Integer> descScoreSet = scores.descendingSet();
		// for(Integer data:descScoreSet) {
		// System.out.println(data);
		// }
		// print(scores.descendingSet(),"Descending");
		// print(scores.tailSet(80,true),"tailSet");
		print(scores.subSet(80, true, 90, false), "subsSet");

	}

	private static void print(NavigableSet<Integer> scores, String title) {

		System.out.println(title + "---------");
		for (Integer data : scores) {
			System.out.println(data);
		}
	}

	private static void print(TreeSet<Integer> scores, String title) {
		System.out.println(title + "Sort---------");
		for (Integer data : scores) {
			System.out.println(data);
		}

	}

	private static void print2(TreeSet<Integer> scores) {
		System.out.println("가장 낮은 점수:" + scores.first());
		System.out.println("가장 높은 점수:" + scores.last());
		System.out.println("가장 높은 점수:" + scores.lower(95));
		System.out.println("가장 높은 점수:" + scores.higher(95));
		System.out.println("가장 높은 점수:" + scores.floor(95));
		System.out.println("가장 높은 점수:" + scores.ceiling(96));

	}

	private static void print(TreeSet<Integer> scores) {
		System.out.println("===기본출력은 Ascending Sort===");
		for (Integer data : scores) {
			System.out.println(data);
		}

	}

	private static void f2() {
		Properties pro = new Properties();

		try {
			pro.load(CollectionTest2.class.getResourceAsStream("oracleDB.properties"));

			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			String myname = pro.getProperty("myname");
			String myname2 = pro.getProperty("myname2", "AAA");// null일 때 default값주기

			System.out.println(driver);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			System.out.println(myname);
			System.out.println(myname2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void f1() {
		Map<String, Integer> map = new Hashtable<>();
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					// System.out.println(getName()+"!!!!"+i);
					map.put(String.valueOf(i), i);
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 1001; i <= 2000; i++) {

					// System.out.println(getName()+"@@@@"+i);
					map.put(String.valueOf(i), i);
				}
			}
		};
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // t1이 종료될 때 까지 기다림

		System.out.println("entry개수:" + map.size());

	}

}
