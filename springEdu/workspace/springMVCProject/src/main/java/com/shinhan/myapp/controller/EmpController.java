package com.shinhan.myapp.controller;

import java.util.List;

import org.firstzone.myapp.dept.DeptService;
import org.firstzone.myapp.emp.EmpDTO;
import org.firstzone.myapp.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.myapp.model.BoardDTO;

@Controller
@RequestMapping("/emp")
public class EmpController {

	// @Autowired�� Ÿ���� ������ �ڵ����� injection
	@Autowired
	EmpService eService;
	
	@Autowired
	DeptService dService;

	@RequestMapping("/empAll.do")
	public String empAll(Model model) {
		List<EmpDTO> emplist2 = eService.selectAll();
		model.addAttribute("emplist", emplist2);
		// view�̸��� ���ϵȴ�
		// viewResolver�� ���λ� + view�̸� + ���̻�
		// view�� forward�ȴ�.(�ּҴ� �ٲ��� ����)
		return "emp/emplist";
	}

	@GetMapping("/empDetail.do")
	public void detail(Model model,
			@RequestParam("empid") Integer empid2) {
		model.addAttribute("empInfo",eService.selectByID(empid2));
		model.addAttribute("deptlist",dService.selectAll());
		model.addAttribute("mlist",eService.selectAllManager());
		model.addAttribute("jlist",eService.selectAllJob());
	}
	//�����â ���
	@GetMapping("/empInsert.do")
	public void insertDisplay(Model model) {
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("mlist", eService.selectAllManager());
		model.addAttribute("jlist", eService.selectAllJob());
	}
	//DB�� �Է�
	@PostMapping("/empInsert.do")
	public String insertDB(EmpDTO empDTO) {
		eService.empInsert(empDTO);
		return "redirect:empAll.do";
	}
	
	@GetMapping("/empIdCheck.do")
	@ResponseBody
	public String test(Integer empid) {
		EmpDTO emp = eService.selectByID(empid);
		if(emp == null) return "0";
		return"1";
	}
	
	@GetMapping("/empDelete.do")
	public String delete(int empid) {
		eService.empDelete(empid);
		
		return "redirect:empAll.do";
	}
	@PostMapping("/empDetail.do")
	public String update(EmpDTO emp) {
		eService.empUpdate(emp);
		
		return "redirect:empAll.do";
	}
	
}
