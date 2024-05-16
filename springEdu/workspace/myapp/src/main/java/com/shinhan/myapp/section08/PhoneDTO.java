package com.shinhan.myapp.section08;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("myphone")
@Data
public class PhoneDTO {
	String model;
	String color;
}
