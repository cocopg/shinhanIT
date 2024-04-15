package com.shinhan.day11;

//1. 조건문 이용하여 안전하게 쓰레드 종료하기
public class PrintThread extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	// interrupt로 Exception발생시켜서 안전하게 쓰레드 종료하기
	public void run() {
		try {
			while (true) {
				System.out.println("실행중...");
				sleep(1);
			}
		} catch (InterruptedException e) {
			// e.printStackTrace();
		}
	}

	public void run2() {
		while (!stop) {
			System.out.println("실행중...");
		}
		System.out.println("리소스정리");
		System.out.println("정상적으로 쓰레드 종료");
	}

}
