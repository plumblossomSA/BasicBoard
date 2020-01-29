package com.board.controller;

import com.board.controller.action.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardServlet") 
//URL�� ���� ����
//��Ĺ�� ������̼��� Ȯ���Ͽ� "�ش� servlet���� �����ϱ� ���ؼ��� URL�� BoardServlet���� �����ϸ� �ȴٴ� ������ ��.
public class BoardServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public BoardServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//doGet : servlet���� get������� ���� �޾��� ��, ����Ǵ� �޼ҵ�
		//�αױ��Ȯ��
		String command = request.getParameter("command"); //board_list��� command��û�� ����
		System.out.println("����Ʈ���� command Ȯ�� :" + command);
		ActionFactory af = ActionFactory.getInstance(); 
		//private���� �����Ͽ� �ܺο��� �����ڸ� ȣ���� ������ ������, �̱���Ŭ������ �ν��Ͻ��� getInstance�޼��带 �̿��� ��ȯ�޾� ����ؾ���
		
		Action action = af.getAction(command); 
		//BoardListAction.java��ü�� �����ؼ� �ش簴ü�� ��û�� ó���ϵ��� ��.
		//ex. ���࿡ command�� board_list�̸� action�� new BoardListAction
		
		System.out.println("test1");
		
		if(action!=null) {
			action.execute(request, response);
		}
		
		System.out.println("test2");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		doGet(request,response);
	}

}
