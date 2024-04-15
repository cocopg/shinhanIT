package com.shinhan.day11.lab;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;

@Getter
class Board {
	private String title;
	private String content;

	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}

}

class BoardDao {

	public List<Board> getBoardList() {

		List<Board> list = new LinkedList<>();
		list.add(new Board("제목1", "내용1"));
		list.add(new Board("제목2", "내용2"));
		list.add(new Board("제목3", "내용3"));

		return list;

	}

}

public class ListExample {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for (Board board : list) {
			System.out.println(board.getTitle() + "-" + board.getContent());
		}

	}

}
