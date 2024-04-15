package com.shinhan.day05;

public class SingleToneClass {

	private static SingleToneClass single = new SingleToneClass();

	private SingleToneClass() {

	}

	public static SingleToneClass getInstance() {
		if(single == null)
			single = new SingleToneClass();
		return single;
	}
}
