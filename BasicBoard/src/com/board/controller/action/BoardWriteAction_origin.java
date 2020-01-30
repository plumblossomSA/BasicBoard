package com.board.controller.action;

import com.board.vo.*;
import com.board.dao.*;

import java.io.IOException;
//import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteAction_origin implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		//String uploadPath = request.getServletContext().getRealPath("/file/upload"); 
		//String uploadPath = request.getRealPath("/fileUpload");
		String uploadPath = "D:\\05. git_storage\\BasicBoard\\BasicBoard\\WebContent\\file\\upload"; 
		int size = 20*1024*1024; //20MB 
		
		//String fname ="";
		//String
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		//MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "euc-kr", new DefaultFileRenamePolicy()); 
	
		BoardVO vo = new BoardVO();
		vo.setlName(multi.getParameter("name")); 
		vo.setlIp(multi.getParameter("ipaddr"));
		vo.setPmAddr(multi.getParameter("macaddr"));
		
		
		if(multi.getFilesystemName("fname") != null) {
			String fname = multi.getFilesystemName("fname");
			//fname = URLEncoder.encode(fname);
			vo.setFname(fname);
		}
	
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		new BoardPagingAction().execute(request, response);
		
	
	}
		

}
