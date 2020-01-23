package com.board.List;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardUpdateFormAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String seq = request.getParameter("seq");
		int seqr = Integer.parseInt(seq);
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.selectOneBoard(seqr);
		
		request.setAttribute("boardview", vo);
		request.getRequestDispatcher("/boardUpdate.jsp").forward(request, response);
	}


}
