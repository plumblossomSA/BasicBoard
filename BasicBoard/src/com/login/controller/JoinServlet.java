package com.login.controller;

import com.login.dao.MemberDAO;
import com.login.vo.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.getRequestDispatcher("view/login/join.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		String userid=request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		MemberVO vo = new MemberVO();
		vo.setUname(name);
		vo.setUid(userid);
		vo.setUpw(pwd);
		vo.setUemail(email);
		vo.setUmobile(phone);
		vo.setAdmin(Integer.parseInt(admin));
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.insertMember(vo);
		
		HttpSession session = request.getSession();
		if(result == 0) {
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}else {
			request.setAttribute("message", "회원가입에 성공했습니다.");
			session.setAttribute("userid", vo.getUid());
		}
		
		request.getRequestDispatcher("view/login/login.jsp").forward(request, response);
	}

}
