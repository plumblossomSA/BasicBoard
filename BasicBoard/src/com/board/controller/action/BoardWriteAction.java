package com.board.controller.action;

import com.board.vo.*;
import com.board.dao.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		BoardVO vo = new BoardVO();
		vo.setlName(request.getParameter("name")); //웹에서 자바로 데이터 받아오기
		vo.setlIp(request.getParameter("ipaddr"));
		vo.setPmAddr(request.getParameter("macaddr"));
		//vo.setPmAddr(request.getParameter("regDate"));
		
		
		System.out.println("--웹에서 가져온 data 출력해보기--");
		System.out.println(vo.getlName());
		System.out.println(vo.getlIp());
		System.out.println(vo.getPmAddr());
		System.out.println("-------------------------");
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		//new BoardListAction().execute(request, response);
		new BoardPagingAction().execute(request, response);
		
	
	}
		

}
