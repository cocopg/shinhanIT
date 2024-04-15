package com.shinhan.day07;

public class InnerInterfaceTest {

	public static void main(String[] args) {
		OkButtomListener ok1 = new OkButtomListener();
		OkButtomListener2 ok2 = new OkButtomListener2();
		
		Button button = new Button();
		button.setListener(ok2);
		button.Click();
		
		//이름없는 구현클래스 만들기
		button.setListener(new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("익명구현class만들기");
				
			}
		});
		button.Click();
		
	}

}
