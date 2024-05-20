package com.shinhan.myapp.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.dept.DeptDTO;
import org.firstzone.myapp.dept.DeptService;
import org.firstzone.myapp.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	DeptService dService;

	@Autowired
	EmpService eService;

	@GetMapping("/deptList.do")
	public void retrieve(Model model, HttpServletRequest request) {
		model.addAttribute("deptlist", dService.selectAll());
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		String result="";
		if(flashMap!=null) {
			result = (String)flashMap.get("deptResult");
			System.out.println(result);
		}
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("deptResult", result);

	}

	@GetMapping("/deptInsert.do")
	public ModelAndView insert(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mlist", eService.selectAllManager());
		mv.setViewName("dept/deptInsert");
		return mv;
	}

	@PostMapping("/deptInsert.do")
	public String update(DeptDTO dept, Integer deptid2, Integer department_id, RedirectAttributes redirectAttr) {
		System.out.println(dept);
		System.out.println(deptid2);
		System.out.println(department_id);

		int result = dService.deptInsert(dept);
		String message;
		if(result>0) {
			message = "update success";
		}else {
			message = "update fail";
		}
		redirectAttr.addFlashAttribute("deptResult", message);

		// return�� void�ΰ�� ==> return "dept/deptList"
		// forward�ȴ� ==> views/dept/deptList.jsp
		// request.getRequestDispathcer("�������̸�"),forward(request,response)
		// redirect:�� ������ ���û�� �ǹ��Ѵ�. ���ο� ��û�̹Ƿ� �ּҰ� �ٲ��. �̶� request�� ���޵��� �ʴ´�.
		// response.redirect("��û�ּ�")
		// redirect:�� ���ٸ� default�� forward�̴�. �� ��û�� �ּҴ� �״���̰� �������� page�� jsp�̴�.
		return "redirect:deptList.do";
	}

	@GetMapping("/deptUpdate.do")
	public void detail(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam("deptid") Integer id) {

		System.out.println("getRemoteAddr: " + request.getRemoteAddr());
		session.setAttribute("deptid", id);
		session.setAttribute("myname", "ŰŰ");

		model.addAttribute("dept", dService.selectById(id));

	}

	@PostMapping("deptDetail.do")
	public String deptInfoView(@ModelAttribute("dept") DeptDTO dept, Model model) {
		System.out.println(dept);
		// model.addAttribute("dept", dept);
		return "dept/deptUpdate_DB";
	}

	@PostMapping("/deptDBUpdate.do")
	public String deptDBUpdate(DeptDTO dept, RedirectAttributes redirectAttr) {
		int result = dService.deptInsert(dept);
		String message;
		if(result>0) {
			message = "insert success";
		}else {
			message = "insert fail";
		}
		redirectAttr.addFlashAttribute("deptResult", message);
		return "redirect:deptList.do";
	}

	@GetMapping("/deptDelete.do")
	public String deptDelete(@RequestParam("deptid") Integer deptid, HttpServletRequest request, RedirectAttributes redirectAttr) {
		String deptid2 = request.getParameter("deptid");
		System.out.println("spring�� ����:" + deptid);
		System.out.println("servlet API�̿�:" + deptid2);
		int result = dService.deptDelete(deptid);
		String message;
		if(result>0) {
			message = "delete success";
		}else {
			message = "delete fail";
		}
		redirectAttr.addFlashAttribute("deptResult", message);
		return "redirect:deptList.do";
	}

}
