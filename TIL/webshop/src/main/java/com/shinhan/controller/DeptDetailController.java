package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptService;
import com.shinhan.dept.DeptDTO;
import com.shinhan.emp.EmpService;

public class DeptDetailController {

	@WebServlet({ "/dept/deptUpdate.do" })
	public class EmpDetailController extends HttpServlet {
		private static final long serialVersionUID = 1L;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptid = request.getParameter("deptid");
		if (deptid == null)
			return;

		DeptService dService = new DeptService();
		int i_deptid = Integer.parseInt(deptid);
		DeptDTO dept = dService.selectById(i_deptid);
		request.setAttribute("deptInfo", response);
	}
}
