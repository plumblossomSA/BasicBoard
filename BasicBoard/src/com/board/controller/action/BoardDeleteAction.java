package com.board.controller.action;

import com.board.vo.*;
import com.board.dao.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(vo);
		
		//new BoardListAction().execute(request, response);
		new BoardPagingAction().execute(request, response);
	}

}
