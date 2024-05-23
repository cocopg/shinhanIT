package com.shinhan.myapp.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.emp.EmpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.myapp.model.BoardDTO;
import com.shinhan.myapp.model.BoardService;

//ajax로 호출
//응답을 data로 view보내서 view가 data를 사용한다.

@RestController
@RequestMapping("/board/api")
public class BoardRestController {

	@Autowired
	BoardService bService;
	
	//모두조회
	@GetMapping(value = "/selectAll")
	public List<BoardDTO> selectAll() {
		List<BoardDTO> blist = bService.selectAll();
		return blist;
	}
	
	//조건조회
	@GetMapping(value ="/detail/{bno}")
	public BoardDTO detail(@PathVariable Integer bno) {
		return bService.selectById(bno);
	}
	
	//입력
	@PostMapping(value = "/insert", produces = "text/plain;charset=utf-8")	
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
		int result = bService.insertBoard(board);
		return result>0?"입력성공":"입력실패";
	}
	//삭제
	@DeleteMapping(value = "/delete/{bno}", produces = "text/plain;charset=utf-8")
	public String delete(@PathVariable("bno") Integer id) {
		int result = bService.deleteBoard(id);
				return result>0?"삭제성공":"삭제실패";
	}
	//수정
	@PutMapping(value="/update", produces = "text/plain;charset=utf-8", consumes = "application/json")
	public String update(@RequestBody BoardDTO board) {
		int result = bService.updateBoard(board);
		return result>0?"업데이트성공":"업데이트실패";
	}
	
	//저장
	
}
