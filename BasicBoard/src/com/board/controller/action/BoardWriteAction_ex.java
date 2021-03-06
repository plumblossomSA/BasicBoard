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
import java.io.*;

public class BoardWriteAction_ex implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String uploadPath = "D:\\05. git_storage\\BasicBoard\\BasicBoard\\WebContent\\file\\upload"; 
		
		int size = 20*1024*1024; 
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
	
		String fname = multi.getFilesystemName("fname");
		
		File oldFile = new File(uploadPath+fname);
		

		fname = new String(fname.getBytes("8859_1"),"EUC-KR");
		
		File newFile = new File(uploadPath+fname);
		if(!oldFile.renameTo(newFile)) {
			byte[] buf = new byte[1024];
			FileInputStream fin = new FileInputStream(oldFile);
			FileOutputStream fout = new FileOutputStream(newFile);
			int read = 0;
			while((read=fin.read(buf,0,buf.length))!=-1) {
				fout.write(buf,0,read);
			}
			fin.close();
			fout.close();
			oldFile.delete();
		}
		
		BoardVO vo = new BoardVO();
		
		vo.setlName(multi.getParameter("name"));
		vo.setlIp(multi.getParameter("ipaddr"));
		vo.setPmAddr(multi.getParameter("macaddr"));
		vo.setFname(fname);
		
		
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		new BoardPagingAction().execute(request, response);
		
	
	}
		

}
