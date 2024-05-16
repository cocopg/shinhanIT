package com.shinhan.myapp.section03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.shinhan.myapp.section02.CarVO;
import com.shinhan.myapp.section02.PeopleVO;

@Configuration
@ComponentScan
public class AppConfig {

	@Bean
	public CarVO carBean() {
		return new CarVO("DDD", 1000);
	}
	
	@Bean
	public PeopleVO makePeople() {
		PeopleVO p1 = new PeopleVO();
		p1.setName("홍길동");
		return p1;
	}
}
