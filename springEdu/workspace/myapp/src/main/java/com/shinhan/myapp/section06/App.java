package com.shinhan.myapp.section06;

import java.util.List;

import org.firstzone.section06.CompanyVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shinhan.myapp.section08.PhoneDTO;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di6.xml");

		CompanyVO a = ctx.getBean("companyVO", CompanyVO.class);
		System.out.println(a);

		PhoneDTO b = ctx.getBean("myphone", PhoneDTO.class);
		System.out.println(b);

		BoardService service = ctx.getBean("bService", BoardService.class);
		List<BoardDTO> bList=service.selectAll();
		bList.stream().forEach(board->System.out.println(board));
	}
}
