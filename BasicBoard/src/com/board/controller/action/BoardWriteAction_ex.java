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
		
		//업로드될 파일의 저장경로
		String uploadPath = "D:\\05. git_storage\\BasicBoard\\BasicBoard\\WebContent\\file\\upload"; //파일을 저장할 경로
		
		//파일 최대사이즈 20MB
		int size = 20*1024*1024; 
		
		//오라일리의 cos.jar파일 업로드를 위한 준비
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		//업로드될 파일이름
		String fname = multi.getFilesystemName("fname");
		
		File oldFile = new File(uploadPath+fname);
		
		//업로드될 파일 이름 한글화(웹상에서)
		//한글 파일명이 깨진것 수정
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
		//-> 이방식으로 하면 웹에 파일명은 	%3F%3F%3F%3F%3F%3F%3F%3F.jpg 식으로 올라가고, 저장된 실제 파일명은 여전히 꺠짐.
		//-> 웹에서 내려받기 할때도 파일명이 ________.jpg식으로 보이며, 파일도 엑박임.
		
		BoardVO vo = new BoardVO();
		
		vo.setlName(multi.getParameter("name")); //웹에서 자바로 데이터 받아오기
		vo.setlIp(multi.getParameter("ipaddr"));
		vo.setPmAddr(multi.getParameter("macaddr"));
		vo.setFname(fname);
		
		
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		new BoardPagingAction().execute(request, response);
		
	
	}
		

}
