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
	
	//�ٿ�ε��� ���ϸ��� �����´�
	String fileName = request.getParameter("fname");
	
	//������ �ִ� �����θ� �����´�
	String folder = request.getServletContext().getRealPath("file/upload");
	
	//������ ���� ��θ� �����
	String filePath = folder+"\\"+fileName;
	System.out.println("������ ������");
	System.out.println(filePath);
	
	try {
		File file = new File(filePath);
		byte b[] = new byte[(int) file.length()];
		
		//page�� contentType���� �������� �ٲٱ� ���� �ʱ�ȭ
		response.reset();
		response.setContentType("application/octet-stream");
		
		//�ѱ����ڵ�
		String encoding = new String(fileName.getBytes("euc-kr"),"8859_1");
		
		//���� ��ũ�� Ŭ������ �� �ٿ�ε� ����ȭ���� ��µǰ� ó���ϴ� �κ�
		response.setHeader("Content-Disposition", "attachment;filename="+encoding);
		response.setHeader("Content-Length", String.valueOf(file.length()));
		
		if(file.isFile()) {
			
			FileInputStream fileInputStream = new FileInputStream(file);
			ServletOutputStream servletOutputStream = response.getOutputStream();
			
			int readNum = 0;
			while((readNum = fileInputStream.read(b)) != -1) {
				servletOutputStream.write(b,0,readNum);
			}
			
			servletOutputStream.close();
			fileInputStream.close();
		}
	}catch(Exception e) {
		System.out.println("Download Exception : " + e.getMessage());
	}
	
	//return null;
		
	}
}

