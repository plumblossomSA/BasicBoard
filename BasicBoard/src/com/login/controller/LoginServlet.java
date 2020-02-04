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
		
		//로그인상태를 알수 있는 것 - session
		
		//어디로 갈지 경로 미리 설정
		String url = "view/login/login.jsp";
		
		//세션에 데이터가 있으면->main_frame.jsp, 데이터가 없으면->login.jsp
		HttpSession session = request.getSession();
		
		//loginUser로 attribute 달아놓기
		if(session.getAttribute("loginUser") != null) { //로그인상태라면
			url = "main_frame.jsp"; //바로 메인화면으로 가자
		}
		
		//login.jsp로 가서 id/pw 입력
		//response.sendRedirect(); : 데이터를 보내야 하는 상황이면 url에 데이터 일일이 써야함
		//RequestDispatcher : 쓰지 않아도 데이터를 실어서 넘어감.
		
		request.getRequestDispatcher(url).forward(request,  response);
	}
	
	//id,pw 데이터를 갖고 doPost로 옮.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//request로 넘어온 아이디와 비번을 DAO로 넘김.
		String url="view/login/login.jsp";
		
		String userid = request.getParameter("uid");
		String pwd = request.getParameter("upw");
		
		System.out.println("id/비번 reqeuset.getParameter로 잘 넘어왔는지 확인");
		System.out.println(userid);
		System.out.println(pwd);
		
		//리턴받을 수 있는 인스턴스 객체가 있음
		//그래서 MemberDAO타입으로 받으면 됨
		MemberDAO dao = MemberDAO.getInstance();
		
		//dao에 id와 pw 를 체크하러갔다 결과값(0,1,-1)을 가지고 옮.
		int result = dao.userCheck(userid,pwd);
		System.out.println(result);
		
		if(result == 1) {
			
			//세션에 로그인한 ID/pw 정보를 올려놓자(loginUser)
				
			url="main_frame.jsp";
			MemberVO vo = dao.getMember(userid); //통과된 회원의 정보를 session에 등록 (6개 항목을가져옴)	
			HttpSession session = request.getSession(); 
			session.setAttribute("loginUser", vo); 
			//우리끼리 통행권을 만들어놓음, loginUser
			//doGet메소드에서 loginUser의 null 여부를 보고 main으로 갈지, login.jsp로 갈지 판단.
			
			request.setAttribute("message","로그인 성공했습니다.");
			
			
		}else if(result == 0) {
			
			request.setAttribute("message","비밀번호를 확인해주세요");
			
		}else if(result == -1) {
			
			request.setAttribute("message", "존재하지 않는 회원입니다.");
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}


}
