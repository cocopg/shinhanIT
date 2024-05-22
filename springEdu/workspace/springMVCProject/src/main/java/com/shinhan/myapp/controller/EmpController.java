package com.shinhan.myapp.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.firstzone.myapp.dept.DeptService;
import org.firstzone.myapp.emp.EmpDTO;
import org.firstzone.myapp.emp.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.myapp.model.BoardDTO;
import com.shinhan.myapp.util.DateUtil;

@Controller
@RequestMapping("/emp")
public class EmpController {

	// @Autowired는 타입이 같으면 자동으로 injection
	@Autowired
	EmpService eService;

	@Autowired
	DeptService dService;
	
	Logger logger = LoggerFactory.getLogger(EmpController.class);

	//deptSelect=0&jobSelect=all&hdate=2005-01-01&salary=5000
	@RequestMapping("/empAll2.do")
	public String empCondition(Model model,
			HttpSession session,
			Integer deptSelect, String jobSelect, String hdate, Integer salary) {
		
		//선택한 값을 session에 저장하기
		session.setAttribute("deptSelect", deptSelect);
		session.setAttribute("jobSelect", jobSelect);
		session.setAttribute("hdate", hdate);
		session.setAttribute("salary", salary);
		
		Date startDate = DateUtil.getSQLDate(hdate);
		List<EmpDTO> emplist2 = eService.selectByCondition(deptSelect, jobSelect, startDate, salary);
		
		logger.info(hdate);
		
		model.addAttribute("emplist", emplist2);
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("jlist", eService.selectAllJob());
		return "emp/emplist";
	}
	
	@RequestMapping("/empAll.do")
	public String empAll(Model model, Integer deptid, String jobid) {
		List<EmpDTO> emplist2 = null;

		if (deptid == null && jobid == null) {
			emplist2 = eService.selectAll();
		} else {
			if (deptid != null && jobid == null) {
				if (deptid == 0) {
					emplist2 = eService.selectAll();
				} else {
					emplist2 = eService.selectByDeptID(deptid);
				}
			} else {
				if (jobid.equals("all")) {
					emplist2 = eService.selectAll();
				} else {
					emplist2 = eService.selectByJob(jobid);
				}
			}

		}

		model.addAttribute("emplist", emplist2);
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("jlist", eService.selectAllJob());
		// view이름이 리턴된다
		// viewResolver가 접두사 + view이름 + 접미사
		// view가 forward된다.(주소는 바뀌지 않음)
		return "emp/emplist";
	}

	@GetMapping("/empDetail.do")
	public void detail(Model model, @RequestParam("empid") Integer empid2) {
		model.addAttribute("empInfo", eService.selectByID(empid2));
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("mlist", eService.selectAllManager());
		model.addAttribute("jlist", eService.selectAllJob());
	}

	// 입출력창 출력
	@GetMapping("/empInsert.do")
	public void insertDisplay(Model model) {
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("mlist", eService.selectAllManager());
		model.addAttribute("jlist", eService.selectAllJob());
	}

	// DB에 입력
	@PostMapping("/empInsert.do")
	public String insertDB(EmpDTO emp) {
		eService.empInsert(emp);
		return "redirect:empAll.do";
	}

	@GetMapping("/empIdCheck.do")
	@ResponseBody
	public String test(Integer empid) {
		EmpDTO emp = eService.selectByID(empid);
		if (emp == null)
			return "0";
		return "1";
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
