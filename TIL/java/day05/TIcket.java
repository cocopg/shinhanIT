package com.shinhan.day05;

import java.util.Arrays;

public class TIcket {
	public static void main(String[] args) {
		int[] tickets = { 10, 8, 20000 };
		int[][][] requests = { { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } }, { { 1, 9 }, { 3, 6 }, { 2, 5 } },
				{ { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } } };
		for (int testcast = 0; testcast < tickets.length; testcast++) {

			System.out.println("-------------------testcast[" + testcast + "]");
			// bubbleSort(requests[testcast]);
			javaSort(requests[testcast]);// sort는 2개를 비교
			int result = solution(tickets[testcast], requests[testcast]);
			System.out.println("판매개수: " + result);

			for (int[] arr : requests[testcast]) {
				System.out.println(Arrays.toString(arr));
			}
		}

	}

	private static void javaSort(int[][] requests) {
		Arrays.sort(requests, (a, b) -> {
			if (a[0] == b[0])
				return b[1] - a[1]; // descending
			return a[0] - b[0]; // ascending
		});

		/*
		 * Integer[] score = { 10, 100, 88, 44, 77, 33 };
		 * System.out.println(Arrays.toString(score)); Arrays.sort(score, (a, b) -> a -
		 * b); // < = > System.out.println(Arrays.toString(score));
		 */
	}

	/*
	 * private static void bubbleSort(int[][] requests) { for (int i = 0; i <
	 * requests.length; i++) { for (int j = 0; j < requests.length - i - 1; j++) {
	 * if (requests[i][0] > requests[j+1][0]) { int[] rank = requests[i];
	 * requests[i] = requests[j]; requests[j] = rank; swap(requests, j, j + 1); }
	 * else if (requests[i][0] == requests[j][0] && requests[i][1] < requests[j +
	 * 1][1]) { swap(requests, j, j + 1); } } }
	 * 
	 * }
	 */

	// tickets: 티켓 수
	// requests: 회원 등급, 티켓 구매 수량
	public static int solution(int tickets, int[][] requests) {
		int result = 0;
		for (int[] order : requests) {
			if (tickets >= order[1]) {
				tickets -= order[1];
				result += order[1];
			}
		}
		return result;
	}

}
