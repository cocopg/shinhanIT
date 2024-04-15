package com.shinhan.day11;

//데몬(Deamon)
//주 쓰레드를 도와주는 쓰레드
//주가 끝나면 같이 끝난다.
public class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업내용을 저장한다.");
	}
	public void run() {
		while(true) {
			try {
				sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			save();
		}
	}

}
