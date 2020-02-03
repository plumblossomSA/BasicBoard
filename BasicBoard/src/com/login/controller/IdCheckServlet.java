package com.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.MemberDAO;

@WebServlet("/idCheck.do")
public class IdCheckServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String userid = request.getParameter("userid");
		System.out.println("서블릿에서 아이디 잘 들어왔는지 확인");
		System.out.println(userid);
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.confirmID(userid);
		
		request.setAttribute("result", result);
		request.setAttribute("userid", userid);
		
		request.getRequestDispatcher("view/login/idCheck.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}

}
