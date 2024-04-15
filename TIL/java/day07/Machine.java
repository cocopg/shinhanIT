package com.shinhan.day07;

public interface Machine {
	void powerOn(String title);

}

//interface구현 클래스를 만든다....만약에 만들어야하는 경우가 많다면 좋은 방법이 아니다.
//2. 익명구현 class를 만든다.필요시마다 만들고 제거된다.
//3.interface내에 메서드가 하나밖에 없다면 람다표현식을 이용한다.
