package com.board.controller.action;

import com.board.vo.*;
import com.board.dao.*;

import java.io.IOException;

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
		String uploadPath = "D:\\05. git_storage\\BasicBoard\\BasicBoard\\WebContent\\fileUpload";
		System.out.println(uploadPath);
		
		int size = 20*1024*1024; //20MB
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
	
		BoardVO vo = new BoardVO();
		System.out.println("실행됬는지 확인 ");
		vo.setlName(multi.getParameter("name")); //웹에서 자바로 데이터 받아오기
		vo.setlIp(multi.getParameter("ipaddr"));
		vo.setPmAddr(multi.getParameter("macaddr"));
		
		//파일업로드
		if(multi.getFilesystemName("fname") != null) {
			String fname = multi.getFilesystemName("fname");
			//String m_fileFullPath=uploadPath + "/" + fname;
			//vo.setFpath(m_fileFullPath);
			
			vo.setFname(fname);
		}
		
		//vo.setFname(request.getParameter("fname"));
		//vo.setPmAddr(request.getParameter("regDate"));
		
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		//new BoardListAction().execute(request, response);
		new BoardPagingAction().execute(request, response);
		
	
	}
		

}
