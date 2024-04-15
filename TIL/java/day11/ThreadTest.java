package com.shinhan.day11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.shinhan.day10.thread.BathRoom;
import com.shinhan.day10.thread.BathRoomThread;

public class ThreadTest {

	public static void main(String[] args) {
		f9();

	}

	private static void f9() {
		BathRoom room = new BathRoom();
		BathRoomThread t1 = new BathRoomThread(room, "김");
		BathRoomThread t2 = new BathRoomThread(room, "양");
		BathRoomThread t3 = new BathRoomThread(room, "박");
		t1.start();
		t2.start();
		t3.start();

	}

	private static void f8() {
		Thread thread = new MovieThread();
		thread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

	private static void f7() {
		ExecutorService service = Executors.newFixedThreadPool(5);

		for (int i = 1; i <= 100; i++) {
			int end = i;
			Future<Integer> result = service.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int j = 1; j <= end; j++) {
						sum += j;
					}
					System.out.println(Thread.currentThread().getName() + ":" + end + "까지 합 ==>" + sum);
					return sum;
				}

			});
			try {
				result.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		service.shutdown();

	}

	private static void f6() {
		String s = "JAVA";
		int score = 100;
		class LocalClass {
			void mothod1() {
				// System.out.println(score);
				System.out.println(s);
			}
		}
		score = 200;

		Runnable r = new Runnable() {

			@Override
			public void run() {
				// System.out.println(score);
				System.out.println(s);

			}
		};
	}

	private static void f5() {
		String[][] mails = new String[1000][3];
		int i = 1;
		for (String[] arr : mails) {
			arr[0] = "admin@my.com";
			arr[1] = "member" + i + "@my.com";
			arr[1] = "신상품 입고되었습니다.";
			i++;
		}

		// MultiThread(5개)로 100영역에 이메일을 보내기
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int index = 1; index < 1000; index++) {
			int seq = index; // 값을 복사
			service.execute(new Runnable() { // 익명구현클래스
				@Override
				public void run() {
					String message = "쓰레드이름:" + Thread.currentThread().getName() + "\nfrom:" + mails[seq][0] + "\nto:"
							+ mails[seq][1] + "\n내용:" + mails[seq][2];
					System.out.println(message);
				}

			});
		}
	}

	private static void f4() {
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true);
		t1.start();

	}

	private static void f3() {
		PrintThread t1 = new PrintThread();
		t1.start();
		// t1.stop();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.setStop(true);
	}

	private static void f2() {
		// 여러 쓰레드가 공유하는 공유데이터
		Calculator calculator = new Calculator();

		User1Thread t1 = new User1Thread();
		t1.setCalculator(calculator);

		User2Thread t2 = new User2Thread();
		t2.setCalculator(calculator);

		t1.start();
		t2.start();

	}

	private static void f1() {
		WorkThread t1 = new WorkThread("WorkThread1");
		WorkThread t2 = new WorkThread("WorkThread2");
		t1.start();
		t2.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.work = false;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.work = true;
	}

}
