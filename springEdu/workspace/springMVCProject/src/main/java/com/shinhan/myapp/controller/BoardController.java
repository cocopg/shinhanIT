package com.shinhan.myapp.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.emp.EmpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.myapp.model.BoardDTO;
import com.shinhan.myapp.model.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService bService;
	
	@RequestMapping("/selectAll.do")
	public String test1(Model model, HttpServletRequest req) {
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(req);
		String message ="";
		if(flashMap!=null) {
			message = (String)flashMap.get("resultMessage");
		}
		
		List<BoardDTO> blist = bService.selectAll();
		System.out.println("/board/selectAll.do요청");
		model.addAttribute("blist",blist);
		return "board/boardlist"; //forward됨=>접두사+"board/boardlist"+접미사
	}
	@GetMapping("/boardInsert.do")
	public void test2() {
		
	}
	
	@PostMapping("/boardInsert.do")	
	public String test3(MultipartHttpServletRequest multipart, HttpSession session) throws UnsupportedEncodingException {
		BoardDTO board = new BoardDTO();
		HttpServletRequest request = (HttpServletRequest) multipart;
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		EmpDTO emp = (EmpDTO)session.getAttribute("emp");
		String writer = null;
		if(emp == null) {
			writer = "손님";
		}else {
			writer = emp.getFirst_name() + emp.getLast_name();
		}
		
		board.setWriter(writer);
		
		List<MultipartFile> fileList = multipart.getFiles("pic");
		String path = request.getSession().getServletContext().getRealPath("./resources/uploads");
		File fileDir = new File(path);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		long time = System.currentTimeMillis();
		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); //
			String saveFileName = String.format("%d_%s", time, originFileName);
			board.setPic(saveFileName);
			try {
				mf.transferTo(new File(path, saveFileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("board:" + board);
		bService.insertBoard(board);
		// forward:요청을 위임
		// redirect:재요청
		return "redirect:selectAll.do";
	}
	/*
	@PostMapping("/boardInsert.do")
	public String test3(BoardDTO board, RedirectAttributes attr, HttpSession session) {
		
		EmpDTO emp = (EmpDTO)session.getAttribute("emp");
		String writer = emp.getFirst_name() + emp.getLast_name();
		board.setWriter(writer);
		int result = bService.insertBoard(board);
		String message;
		if(result>0) {
			message = "insert success";
		}else {
			message = "insert fail";
		}
		attr.addFlashAttribute("resultMessage", message);
		//forward:요청을 위임
		//redirect:재요청
		return "redirect:selectAll.do";
		//request.sendRedirect("selectAll.do")
	}
	*/

	@GetMapping("/boardDetail.do")
	public String detail(@RequestParam("bno") Integer bno, Model model) {
		model.addAttribute("board",bService.selectById(bno));
		
		return "board/boardDetail";
	}
	
	@PostMapping("/boardDetail.do")
	public String update(BoardDTO board) {
		bService.updateBoard(board);
		
		return "redirect:selectAll.do";
	}
	
	//@RequestMapping(value="/boardDelete.do", method = RequestMethod.GET)
	@GetMapping("/boardDelete.do")
	public String delete(Integer bno) {
		bService.deleteBoard(bno);
		
		return "redirect:selectAll.do";
	}
	
	@GetMapping("/selectDelete.do")
	public String selectDelete(Integer[] checkBno) {
		
		int result = bService.deleteBoardArray(checkBno);
		return "redirect:selectAll.do";
	}

}
