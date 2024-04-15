package com.shinhan.day08;

public class ExceptionTest2 {

	public static void main(String[] args) {
		try {
			method2(60);
		} catch (ScoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void method2(int score) throws ScoreException {
		if(score<=70) throw new ScoreException("70 초과만 가능");

	}

	public static void main1(String[] args) {
		try {
			method1(70);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("********");
	}

	private static void method1(int score) throws Exception {

		// 조건에 맞지 않으면 강제로 예외를 발생하고자 한다(raise)
		// if (score <= 70) throw new RuntimeException();
		/*
		 * try { if (score <= 70) throw new Exception("오류!!!!"); } catch (Exception e) {
		 * System.out.println(e.getMessage()); }
		 */
		if (score <= 70)
			throw new Exception("오류!!!!");
		System.out.println("----------------------");

	}
}
