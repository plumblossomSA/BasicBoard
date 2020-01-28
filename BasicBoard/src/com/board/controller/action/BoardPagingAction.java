package com.board.controller.action;

import com.board.vo.*;
import com.board.dao.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardPagingAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String url="/view/board/boardList_pg.jsp";
		
		int spage = 1;
		String page = request.getParameter("page");
		//String page = "1";
		
		//System.out.println("-----------------------------------------------page값");
		//System.out.println(page);
		
		if(page != null) spage = Integer.parseInt(page);
		
		BoardDAO dao = new BoardDAO();
		int listCount = dao.getBoardCnt();
		
		int maxPage = (int)(listCount/5.0+0.9);
		
		if(spage>maxPage) spage = maxPage;
		List<BoardVO> list = dao.getBoardListWithPaging(spage*5-4); //여기수정해야함 함수
		
		int startPage = (int)(spage/5.0+0.8)*5-4;
		int endPage = startPage +4;
		if(endPage > maxPage) endPage = maxPage;
		
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
	
		request.setAttribute("boardList", list); //jsp에서 list값을 받을 수 있도록함
		request.getRequestDispatcher(url).forward(request, response);
	
	}

}
