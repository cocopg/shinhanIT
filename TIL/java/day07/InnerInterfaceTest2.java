package com.shinhan.day07;

class Window{
	static interface Listener{
	void alert();
	}
	Listener listener;
	void setListener(Listener listener) {
		this.listener = listener;
	}
	void execute() {
		listener.alert();
	}
}

class MyListener1 implements Window.Listener{
	public void alert() {
		System.out.println("1.구현 클래스에서 메서드를 재정의한다.");
	}
}


public class InnerInterfaceTest2 {

	public static void main(String[] args) {
		Window win = new Window();
		//1. 구현클래스 이용
		MyListener1 my1 = new MyListener1();
		win.setListener(my1);
		win.execute();
		
		//2.익명구현클래스를 만든다.
		Window.Listener my2 = new Window.Listener() {
			
			@Override
			public void alert() {
				System.out.println("2.익명구현 클래스를 만든다.");
				
			}
		};
		win.setListener(my2);
		win.execute();
		//3.람다표현식을 사용(메서드가 1개있을떄만)
		win.setListener(()->System.out.println("람다표현식을 사용(메서드가 1개인 경우만 가능)"));
		win.execute();

	}

}
