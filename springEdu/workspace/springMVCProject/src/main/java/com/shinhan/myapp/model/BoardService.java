package com.shinhan.myapp.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("bService2")  // @Component + Service, ¡§¿«
public class BoardService {

//	BoardDAO boardDAO = new BoardDAO();
	
	//???ûÖ?ù¥ Í∞ôÏúºÎ©? Í∞ùÏ≤¥Î•? Injection?ïú?ã§.
	@Autowired
	@Qualifier("bDAO") //¿Ã∏ß¿∏∑Œ ∫“∑Øø¿±‚
	BoardDAO boardDAO;

	public List<BoardDTO> selectAll() {
		return boardDAO.selectAll();
	}
	
	public BoardDTO selectById(int bno) {
		return boardDAO.selectById(bno);
	}
	
	public int insertBoard(BoardDTO board) {
		return boardDAO.insertBoard(board);
	}
	
	public int updateBoard(BoardDTO board) {
		return boardDAO.updateBoard(board);
	}
	
	public int deleteBoard(int bno) {
		return boardDAO.deleteBoard(bno);
	}

	public int deleteBoardArray(Integer[] checkBno) {
		
		return boardDAO.deleteBoardArray(checkBno);
	}

}
