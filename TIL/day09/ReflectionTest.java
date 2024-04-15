package com.shinhan.day09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.net.URL;

public class ReflectionTest {

	public static void main(String[] args) throws FileNotFoundException {
		f2();

	}

	private static void f2() throws FileNotFoundException {
		// new FileReader("src/com/shinhan/day09/ComputerVO.java");
		Class<?> cls = ReflectionTest.class;
		URL url = cls.getResource("크레페.webp");
		System.out.println(url.getPath());

		InputStream fis = cls.getResourceAsStream("aa.xml");
		InputStreamReader isr = new InputStreamReader(fis);
		int i;
		try {
			while ((i = isr.read()) != -1) {
				System.out.println((char) i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void f1() {
		// 리플렉션
		Class<ComputerVO> cls = ComputerVO.class;
		Constructor<?>[] cons = cls.getDeclaredConstructors();
		for (Constructor<?> cc : cons) {
			System.out.println(cc.getName());
			System.out.println(cc.getParameterCount());

			for (Parameter param : cc.getParameters()) {
				System.out.println(param.getName());
			}

			System.out.println("-----------------------");
		}
	}

}
