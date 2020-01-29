package com.board.controller;

import com.board.controller.action.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardServlet") 
//URL과 서블릿 매핑
//톰캣은 어노테이션을 확인하여 "해당 servlet으로 접근하기 위해서는 URL에 BoardServlet으로 접근하면 된다는 매핑을 함.
public class BoardServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public BoardServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//doGet : servlet에서 get방식으로 전달 받았을 때, 실행되는 메소드
		//로그기록확인
		String command = request.getParameter("command"); //board_list라는 command요청을 받음
		System.out.println("프론트에서 command 확인 :" + command);
		ActionFactory af = ActionFactory.getInstance(); 
		//private으로 선언하여 외부에서 생성자를 호출할 수없기 떄문에, 싱글톤클래스의 인스턴스는 getInstance메서드를 이용해 반환받아 사용해야함
		
		Action action = af.getAction(command); 
		//BoardListAction.java객체를 생성해서 해당객체가 요청을 처리하도록 함.
		//ex. 만약에 command가 board_list이면 action에 new BoardListAction
		
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
