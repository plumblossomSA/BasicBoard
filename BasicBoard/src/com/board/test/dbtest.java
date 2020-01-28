package com.board.test;

import com.board.dao.*;
import com.board.vo.*;
import java.util.List;

public class dbtest {
public static void main(String[] args) {
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAllBoards();
		
		for(BoardVO vo: list) {
			System.out.println(vo.getlIp());
		}
	}


}
