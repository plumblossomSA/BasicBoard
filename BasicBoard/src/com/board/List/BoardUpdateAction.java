package com.board.List;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardUpdateAction implements Action{
	
	@Override
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//String seq = request.getParameter("seq");
		//int seqr = Integer.parseInt(seq);
		
		BoardVO vo = new BoardVO();
		//vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		//vo.setSeq(request.getParameter("seq"));

		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		vo.setlName(request.getParameter("name")); //웹에서 자바로 데이터 받아오기
		vo.setlIp(request.getParameter("ipaddr"));
		vo.setPmAddr(request.getParameter("macaddr"));
		
		BoardDAO dao = new BoardDAO();
		
		dao.updateBoard(vo);
		//new BoardListAction().execute(request, response);
		new BoardPagingAction().execute(request, response);
	}

}
