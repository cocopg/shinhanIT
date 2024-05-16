package com.shinhan.myapp.section06;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class ComputerVO {
	String model;
	int price;
	String os;
}
