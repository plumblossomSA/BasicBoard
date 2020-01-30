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
		
		request.setCharacterEncoding("utf-8");
		
		String url="/view/board/boardList_pg.jsp";
		
		int spage = 1;
		String page = request.getParameter("page");
		//String page = "1";
		
	
		if(page != null) spage = Integer.parseInt(page);
		
		BoardDAO dao = new BoardDAO();
		int listCount = dao.getBoardCnt();
		
		int maxPage = (int)(listCount/5.0+0.9);
		
		if(spage>maxPage) spage = maxPage;
		List<BoardVO> list = dao.getBoardListWithPaging(spage*5-4);
		

		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		int startPage = (int)(spage/5.0+0.8)*5-4;
		int endPage = startPage +4;
		if(endPage > maxPage) endPage = maxPage;
		
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
	
		request.setAttribute("boardList", list);
		request.getRequestDispatcher(url).forward(request, response);
	
	}

}
