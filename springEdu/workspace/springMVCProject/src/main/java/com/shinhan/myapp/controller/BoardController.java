package com.shinhan.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shinhan.myapp.model.BoardDTO;
import com.shinhan.myapp.model.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService bService;
	
	@RequestMapping("/selectAll.do")
	public String test1(Model model) {
		List<BoardDTO> blist = bService.selectAll();
		System.out.println("/board/selectAll.do요청");
		model.addAttribute("blist",blist);
		return "board/boardlist";
	}
	@GetMapping("/boardInsert.do")
	public void test2() {
		
	}
	@PostMapping("/boardInsert.do")
	//public String test3(String title, String content, String pic) {
	public String test3(BoardDTO board) {
		//BoardDTO board = new BoardDTO();
		//board.settitle(request.getParameter("title"))
		System.out.println(board);
		bService.insertBoard(board);
		
		//forward:요청을 위임
		//redirect:재요청
		return "redirect:selectAll.do";
	}
	

	@GetMapping("/boardDetail.do")
	public String detail(int bno, Model model) {
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

}
