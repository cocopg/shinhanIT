package com.shinhan.myapp.section05;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class CompanyVO {
	@Value("신한DS")
	String compName;
	String address;
	List<ComputerVO> computerList;
}
