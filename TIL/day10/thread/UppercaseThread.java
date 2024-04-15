package com.shinhan.day10.thread;

//MutiThread : 
//A. 1)Thread상속 2)run()메서드 재정의 3)new객체생성후 start()..run()수행됨 
//B. 이미 상속받은 부모가 있다면 자바는 멀티상속불가하므로 Runnable interface구현 
class Parent{
	
}

public class UppercaseThread extends Parent implements Runnable{

	@Override
	public void run() {
		// 1.영문자 대문자출력
		for (char i = 'A'; i <= 'Z'; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " i=" + i);
		}
	}

}
