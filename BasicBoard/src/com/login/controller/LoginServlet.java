package com.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.*;
import com.login.vo.*;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String url = "view/login/login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) {
			url = "main_frame.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String url="view/login/login.jsp";
		
		String userid = request.getParameter("uid");
		String pwd = request.getParameter("upw");
		
		System.out.println("id/비번 reqeuset.getParameter로 잘 넘어왔는지 확인");
		System.out.println(userid);
		System.out.println(pwd);
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.userCheck(userid,pwd);
		System.out.println(result);
		
		if(result == 1) {
			
//			url="main_frame.jsp";
//			MemberVO vo = dao.getMember(userid);	
//			HttpSession session = request.getSession();
//			session.setAttribute("loginUser", vo);
			
			request.setAttribute("message","로그인 성공했습니다.");
			url="main_frame.jsp";
			
		}else if(result == 0) {
			
			request.setAttribute("message","비밀번호를 확인해주세요");
			
		}else if(result == -1) {
			
			request.setAttribute("message", "존재하지 않는 회원입니다.");
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}


}
