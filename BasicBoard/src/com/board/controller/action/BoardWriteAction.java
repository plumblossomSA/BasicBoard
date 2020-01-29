package com.board.controller.action;

import com.board.vo.*;
import com.board.dao.*;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//파일업로드(경로, 파일크기, 인코딩, 파일이름 중첩정책)
		//String uploadPath = request.getServletContext().getRealPath("/file/upload"); //파일이 저장될 서버의 경로, 되도록이면 getRealPath 이용하기
		//String uploadPath = request.getRealPath("/fileUpload");
		String uploadPath = "D:\\05. git_storage\\BasicBoard\\BasicBoard\\WebContent\\file\\upload"; //파일을 저장할 경로
		int size = 20*1024*1024; //20MB 파일 최대 사이즈
		
		//String fname ="";
		//String
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		//MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "euc-kr", new DefaultFileRenamePolicy()); //파일명은 깨지지 않지만, 리스트 등록이 안됨.
		
	
		BoardVO vo = new BoardVO();
		System.out.println("실행됬는지 확인 ");
		vo.setlName(multi.getParameter("name")); //웹에서 자바로 데이터 받아오기
		vo.setlIp(multi.getParameter("ipaddr"));
		vo.setPmAddr(multi.getParameter("macaddr"));
		
		
		//파일업로드1
		if(multi.getFilesystemName("fname") != null) {
			String fname = multi.getFilesystemName("fname");
			fname = URLEncoder.encode(fname); //인코더를 사용하면, 웹상에서 파일명이 깨지진 않지만,%3F%..식으로 나옴.실제 dir에 저장된파일명은 여전히 깨짐.
			vo.setFname(fname);
		}
		
		
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		new BoardPagingAction().execute(request, response);
		
	
	}
		

}
