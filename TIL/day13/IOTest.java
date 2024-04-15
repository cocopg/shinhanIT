package com.shinhan.day13;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class IOTest {

	public static void main(String[] args) throws IOException {
		f7();

	}
	

	private static void f7() throws IOException {
		// 파일입력(읽기)
		String filename = "./src/com/shinhan/day13/Review2.java";
		FileReader fis;
		BufferedReader br;

		String i;
		fis = new FileReader(filename);// 파일 열기...2byte씩 처리한다.
		br = new BufferedReader(fis);
		while ((i = br.readLine()) != null) {
			System.out.println(i);
		}

		fis.close();

	}

	private static void f6() throws IOException {
		// 보조스트림 : DataOutputStream, DataInputStream
		String fileName = "aa.txt";
		FileOutputStream fos = new FileOutputStream(fileName);
		DataOutputStream dos = new DataOutputStream(fos);
		fos.write(10);
		fos.write(20);
		dos.writeDouble(10.5);
		dos.writeDouble(20.5);
		dos.writeUTF("문자");
		fos.flush();
		fos.close();

		FileInputStream fis = new FileInputStream(fileName);
		DataInputStream dis = new DataInputStream(fis);
		int a = dis.read();
		int b = dis.read();
		double c = dis.readDouble();
		double d = dis.readDouble();
		String s = dis.readUTF();
		System.out.println(a + b + c + d);
		System.out.println(s);
		fis.close();

	}

	private static void f5() throws IOException {
		// 파일 출력
		String fileName = "aa.txt";
		FileWriter fw = new FileWriter(fileName);
		fw.write("java");
		fw.write("자바");

		// 자원을 반납하지 않으면 다른곳에서 이 파일을 사용할 수 없다.
		fw.close();
	}

	private static void f4() {
		// 모니터 출력
		PrintStream monitor = System.out;
		monitor.println("모니터출력");

	}

	private static void f3() throws IOException {
		// 파일입력(읽기)
		String filename = "./src/com/shinhan/day13/Review2.java";
		FileReader fis;
		int i;
		fis = new FileReader(filename);

		while ((i = fis.read()) != -1) {
			System.out.print((char) i);
		}

		fis.close();

	}

	private static void f2() throws IOException {
		// 파일입력(읽기)
		String filename = "./src/com/shinhan/day13/Review2.java";
		FileInputStream fis;
		int i;
		fis = new FileInputStream(filename);

		while ((i = fis.read()) != -1) {
			System.out.print((char) i);
		}

		fis.close();

	}

	private static void f1() throws IOException {
		// 키보드입력
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		int i;
		while ((i = isr.read()) != 13) { // 엔터키의 아스키코드값이 13
			System.out.print((char) i);
		}

	}

}
