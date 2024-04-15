package com.shinhan.day01;

public class CodeTest1 {

	public static void main(String[] args) {
		int m = 5000;
		int[] ledger = {10000, 24520, -12552,-201125,-12220, 4252};
		solution(m, ledger);
	}

	static void solution(int m, int[] ledger) {
		int rest = 0;
		for (int i = 0; i < ledger.length; i++) {
			if (rest+ledger[i] >= -m) {
				rest = rest + ledger[i];
			}
		}
		System.out.println(rest);
	}
}
