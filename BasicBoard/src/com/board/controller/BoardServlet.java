package com.board.controller;

import com.board.controller.action.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardServlet") 

public class BoardServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L; 
	
	public BoardServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String command = request.getParameter("command"); 
		
		ActionFactory af = ActionFactory.getInstance(); 
		
		Action action = af.getAction(command); 

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
