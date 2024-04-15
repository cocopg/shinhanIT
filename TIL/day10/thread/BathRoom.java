package com.shinhan.day10.thread;

//공유영역
public class BathRoom {
	// synchronized : 하나의 thread가 이 메서드 수행중 Lock건다
	// 즉, 다른 Thread가 접근불가 ,하나의 thread가 메서드 벗어나면 대기thread가 들어온다
	
	boolean isFirst = true;
	
	synchronized void use(String name) {	
		
		if(isFirst && name.equals("김")) {
			isFirst = false;
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(name + "입장");
		System.out.println(name + "사용중");
		System.out.println(name + "퇴장");
		System.out.println("-----------");
		
		notifyAll(); //wait상태의 쓰레드를 실행대기상태로 바꿔준다.
	}

	void use2(String name) {
		synchronized (this) {
			System.out.println(name + "입장");
			System.out.println(name + "사용중");
			System.out.println(name + "퇴장");
			System.out.println("-----------");
		}

	}

}
