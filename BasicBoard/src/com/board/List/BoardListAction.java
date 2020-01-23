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
		
		System.out.println("BoardListAction.java ����");
		String url="/boardList.jsp";
		
		BoardDAO dao = new BoardDAO();
		//BoardDAO dao = BoardDAO.getInstance();
		
	
		List<BoardVO> list = dao.selectAllBoards(); //list�� ���̺��� ��� �����͵��� ������
		System.out.println("dao���� ������ ����Ʈ ��� : ");
		System.out.println(list);
		
		System.out.println("BoardListAction.java ����2");
		
		//request�� boardList�̸����� list�� ��Ƴ��� "boardList.jsp"�������� �̵�
		request.setAttribute("boardList", list); //jsp���� list���� ���� �� �ֵ�����
		request.getRequestDispatcher(url).forward(request, response);
		System.out.println("boardlist�� ����Ʈ���� ����");
	}

}
