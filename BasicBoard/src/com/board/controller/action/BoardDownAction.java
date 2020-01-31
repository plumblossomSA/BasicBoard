package com.board.controller.action;

import java.io.*;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDownAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	//다운로드할 파일명을 가져옴
	String fileName = request.getParameter("fname");
	
	//파일이 있는 절대경로를 가져옴
	//현재 업로드된 파일은 WebContent기준 file/upload에 있음
	String folder = request.getServletContext().getRealPath("file/upload");
	
	//파일 절대경로 생성
	String filePath = folder+"\\"+fileName;
	
	try {
		File file = new File(filePath); //파일경로를 이용하여 파일생성
		byte b[] = new byte[(int) file.length()];
		
		//page의 ContentType등을 동적으로 바꾸기 위해 초기화시킴
		response.reset();
		response.setContentType("application/octet-stream");
		
		System.out.println("BoardDownAction()함수 수행1");
		
		//한글인코딩
		String encoding = new String(fileName.getBytes("euc-kr"),"8859_1");
		
		//파일링크를 클릭했을때 다운로드 저장 화면이 출력되게 처리하는 부분
		response.setHeader("Content-Disposition", "attachment;filename="+encoding);
		response.setHeader("Content-Length", String.valueOf(file.length()));
		
		System.out.println("BoardDownAction()함수 수행2");
		
		//파일이 있을 경우
		if(file.isFile()) {
			
			FileInputStream fileInputStream = new FileInputStream(file);
			ServletOutputStream servletOutputStream = response.getOutputStream();
			
			System.out.println("BoardDownAction()함수 수행3");
			
			//파일을 읽어서 클라이언트쪽으로 저장한다.(Stream객체를 이용해 파일을 출력)
			int readNum = 0;
			while((readNum = fileInputStream.read(b)) != -1) {
				servletOutputStream.write(b,0,readNum);
				System.out.println("BoardDownAction()함수 수행3-1");
			}
			
			servletOutputStream.close();
			fileInputStream.close();
			
			System.out.println("BoardDownAction()함수 수행4");
		}
	}catch(Exception e) {
		System.out.println("Download Exception : " + e.getMessage());
	}
	
	//return null;
	
	System.out.println("BoardDownAction()함수 수행5");
		
	}
}

