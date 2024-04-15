package com.shinhan.day05;

/*접근지정자(Modifier)
1. public : 모든 패키지에서 접근이 가능
2. protected : 같은 패키지에서 접근가능, 다른 패키지인경우 상속받으면 접근가능
3. 생략 : 같은 패키지에서 접근이 가능
4. private : 같은 클래스 내에서 접근가능
class 접근지정자는 : public, 생략
 */
public class Computer {
	private String model;
	protected int price =200;
	public Computer(){
		System.out.println("default생성자 정의함");
	}
	public void setModel(String model){
		this.model=model;
	}

}
