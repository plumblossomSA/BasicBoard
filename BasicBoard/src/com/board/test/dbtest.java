package com.board.test;

import java.util.List;
import com.board.List.BoardDAO;
import com.board.List.BoardVO;

public class dbtest {
public static void main(String[] args) {
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAllBoards();
		
		for(BoardVO vo: list) {
			System.out.println(vo.getlIp());
		}
	}


}
