package com.shinhan.day09;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "price")

//JavaBeans 기술 규격: field는 private, getter/setter, default생성자
//DTO (Data Transfer Object) : data를 전송하기 위해
//VO(Value Object) : 값을 저장하기 위해 만듦
public class Book {
	private String title;
	private int price;
	private String author;
}
