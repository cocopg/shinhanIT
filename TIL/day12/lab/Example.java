package com.shinhan.day12.lab;

import java.util.Arrays;
import java.util.List;

public class Example {
	public static void main(String[] args) {
			List<String> list = Arrays.asList(
			 "This is a java book",
			 "Lambda Expressions",
			 "Java8 supports lambda expressions"
			);
		list.stream().filter(n-> n.toLowerCase().contains("java")).forEach(n->System.out.println(n));
 
}
}