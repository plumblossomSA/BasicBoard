package com.board.List;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.servlet.ServletException;
import java.util.*;


public class BoardListAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("BoardListAction.java 실행");
		String url="/boardList.jsp";
		
		BoardDAO dao = new BoardDAO();
		//BoardDAO dao = BoardDAO.getInstance();
		
	
		List<BoardVO> list = dao.selectAllBoards(); //list로 테이블의 모든 데이터들을 가져옴
		System.out.println("dao에서 가져온 리스트 출력 : ");
		System.out.println(list);
		
		System.out.println("BoardListAction.java 실행2");
		
		//request에 boardList이름으로 list를 담아놓고 "boardList.jsp"페이지로 이동
		request.setAttribute("boardList", list); //jsp에서 list값을 받을 수 있도록함
		request.getRequestDispatcher(url).forward(request, response);
		System.out.println("boardlist로 리스트내용 전송");
	}

}
