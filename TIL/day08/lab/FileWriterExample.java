package com.shinhan.day08.lab;

import java.io.IOException;

public class FileWriterExample {
	public static void main(String[] args) {
			try (FileWriter fw = new FileWriter("file.txt")){
				fw.write("Java");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	public static void f1(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("file.txt");
			fw.write("Java");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
			}
		}
	}
}