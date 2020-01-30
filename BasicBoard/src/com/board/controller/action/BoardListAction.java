package com.board.controller.action;

import com.board.vo.*;
import com.board.dao.*;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.servlet.ServletException;
import java.util.*;


public class BoardListAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String url="/view/board/boardList.jsp";
		
		BoardDAO dao = new BoardDAO();
		//BoardDAO dao = BoardDAO.getInstance();
		
	
		List<BoardVO> list = dao.selectAllBoards(); 
		
		
		request.setAttribute("boardList", list); 
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
