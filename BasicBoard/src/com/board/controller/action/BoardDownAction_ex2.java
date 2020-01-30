package com.board.controller.action;

import java.net.URLEncoder;
import com.board.util.FileDownLoadHelper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

public class BoardDownAction_ex2 implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		

		
		String realPath = "D:\\05. git_storage\\BasicBoard\\BasicBoard\\WebContent\\file\\download\\";
		
		System.out.println("������ ����� ���");
		System.out.println(realPath);

		
		if(request.getParameter("fname") == null || "".equals(request.getParameter("fname"))){

			response.sendRedirect("/view/board/boardView.jsp");

		}else{

			
			String requestFileNameAndPath = request.getParameter("fname");
			String UTF8FileNameAndPath = new String(requestFileNameAndPath.getBytes("8859_1"), "UTF-8");
			String UTF8FileName = UTF8FileNameAndPath.substring(UTF8FileNameAndPath.lastIndexOf("/") + 1).substring(UTF8FileNameAndPath.lastIndexOf(File.separator) + 1);
		
			boolean MSIE = request.getHeader("user-agent").indexOf("MSIE") != -1;
		
			
			String fileNameToSave = "";

			
			if(MSIE){
				
				fileNameToSave = URLEncoder.encode(UTF8FileName, "UTF8").replaceAll("\\+", " ");
			}else{
				
				fileNameToSave = new String(UTF8FileName.getBytes("UTF-8"), "8859_1");

			}

			response.setContentType("application/octet-stream");
			
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameToSave + "\";");

	
			//  String filePathAndName = pageContext.getServletContext().getRealPath("/") + UTF8FileNameAndPath;
			String filePathAndName = realPath + UTF8FileNameAndPath;
			File file = new File(filePathAndName);
			
		
			byte bytestream[] = new byte[2048000];


			if (file.isFile() && file.length() > 0){
				
				FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
					
				int read = 0;
					
				while ((read = bis.read(bytestream)) != -1){
					bos.write(bytestream , 0, read);
				}
				
				bos.close();
				bis.close();
				
			}

		}
	}
	
}

