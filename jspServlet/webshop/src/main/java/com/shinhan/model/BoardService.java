package com.shinhan.model;

import java.util.List;

import com.shinhan.dto.BoardDTO;
import com.shinhan.emp.EmpDAO;

//Service : 비지니스 로직 작성
public class BoardService {

	BoardDAO boradDao = new BoardDAO();
	
	public int deleteBoard(int bno) {
		return boradDao.deleteBoard(bno);
	}
	
	public int updateBoard(BoardDTO board) {
		return boradDao.updateBoard(board); 
	}
	
	public int insertBoard(BoardDTO board) {
		 return boradDao.insertBoard(board);
	}
	
	
	public BoardDTO selectById(int bno) {
		 return boradDao.selectById(bno);
	}
	
	
	public List<BoardDTO> selectAll() {
		 return boradDao.selectAll();
	}

	 
}

