package com.board.controller.action;

import java.net.URLEncoder;
import com.board.util.FileDownLoadHelper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoardDownAction implements Action {
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		response.reset();
		String fileName = request.getParameter("fname");
		System.out.println(fileName);
		
		String downloadPath = "D:\\05. git_storage\\BasicBoard\\BasicBoard\\WebContent\\file\\download";
		String path = downloadPath.trim() + "\\" + fileName.trim();
		System.out.println(path);
		
		String fileName2 = URLEncoder.encode(fileName, "UTF-8");
		
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName2+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");
		
//		out.clear();
//		out=pageContext.pushBody();
		
		try {
			FileDownLoadHelper.copy(path, response.getOutputStream());
			response.getOutputStream().close();
		}catch(Exception e) {
			System.out.println("ok");
			e.printStackTrace();
		}
	}
	

}
