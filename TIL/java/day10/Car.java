package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@ToString
public class Car {
	
	String model;
	int price;
	String color;
	
	
	
	public void run() {
		System.out.println("자동차가 달립니다.");
	}
	
	//ASC : 나의 값, 들어온값
	//값이 같으면 자리이동없음
	//DESC : 들어온값, 나의 값 
	public int compareTo(Car o) {
		//가격 desc, model desc, color asc
		int result = o.price - price;
		if(result == 0) {
			int result2 = o.model.compareTo(model);
			if(result2 == 0) return color.compareTo(o.color);
			return result2;
		}
		return result;
	}
}
