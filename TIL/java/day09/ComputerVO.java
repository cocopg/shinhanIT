package com.shinhan.day09;

import java.util.Objects;

//class : object를 만들기 위한 툴
//object : instance(실체)

//VO(Value Object) : data저장(field여러개), c언어의 Structor와 비슷
//DTO(Data Transfer Object) : data 전송목적
//JavaBeans기술 : default생성자가 반드시 있어야 한다.
public class ComputerVO {
	//1.field(data저장)
	String model;
	int price;
	String company;
	public ComputerVO() {}
	
	public ComputerVO(String model, int price, String company) {
		super();
		this.model = model;
		this.price = price;
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	


	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComputerVO [model=")
		.append(model)
		.append(", price=")
		.append(price)
		.append(", company=")
		.append(company)
		.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComputerVO other = (ComputerVO) obj;
		return Objects.equals(company, other.company) && Objects.equals(model, other.model) && price == other.price;
	}

}
