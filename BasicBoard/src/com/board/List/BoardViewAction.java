package com.board.List;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardViewAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 
		String url = "/boardView.jsp";
		String seq = request.getParameter("seq");
		int seqr = Integer.parseInt(seq);
		//(Integer.parseInt(request.getParameter("num")));
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.selectOneBoard(seqr);
		
		System.out.println("BoardViewAction.java ½ÇÇà");
		System.out.println(vo);
		
		request.setAttribute("boardview", vo);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
