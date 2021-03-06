package com.board.controller.action;

import com.board.vo.*;
import com.board.dao.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardViewAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 
		request.setCharacterEncoding("utf-8");
		
		String url = "/view/board/boardView.jsp";
		String seq = request.getParameter("seq");
		int seqr = Integer.parseInt(seq);
		//(Integer.parseInt(request.getParameter("num")));
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.selectOneBoard(seqr);
		

		
		request.setAttribute("boardview", vo);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
