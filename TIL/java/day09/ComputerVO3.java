package com.shinhan.day09;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//class : object를 만들기 위한 툴
//object : instance(실체)

//VO(Value Object) : data저장(field여러개), c언어의 Structor와 비슷
//DTO(Data Transfer Object) : data 전송목적
//JavaBeans기술 : default생성자가 반드시 있어야 한다.
//@NoArgsConstructor
//@Getter
//@Setter 
//@EqualsAndHashCode
//@ToString
@AllArgsConstructor
@Data

public class ComputerVO3 {
	//1.field(data저장)
	
	@NonNull
	String model;
	int price;
	String company;
	
	@Override
	public String toString() {
		return "ComputerVO3 [price=" + price + ", company=" + company + "]";
	}
}
