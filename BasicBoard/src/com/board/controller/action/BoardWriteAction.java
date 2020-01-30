package com.board.controller.action;

import com.board.vo.*;
import com.board.dao.*;

import java.io.IOException;
//import java.net.URLEncoder;
import java.util.*;
import java.text.*;
import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.AImapFileRenamePolicy;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileUploadRename;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uploadPath = "D:\\05. git_storage\\BasicBoard\\BasicBoard\\WebContent\\file\\upload";
		int size = 20 * 1024 * 1024; // 20MB
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new AImapFileRenamePolicy());

		Enumeration formNames = multi.getFileNames();

		String fileInput = "";
		String fileName = "";
		String type = "";
		File fileObj = null;
		String originFileName = "";
		String fileExtend = "";
		String fileSize = "";

		while (formNames.hasMoreElements()) {
			fileInput = (String) formNames.nextElement(); // 파일인풋 이름
			fileName = multi.getFilesystemName(fileInput); // 파일명
			if (fileName != null) {
				type = multi.getContentType(fileInput); // 콘텐트타입
				fileObj = multi.getFile(fileInput); // 파일객체
				originFileName = multi.getOriginalFileName(fileInput); // 초기 파일명
				fileExtend = fileName.substring(fileName.lastIndexOf(".") + 1); // 파일 확장자
				fileSize = String.valueOf(fileObj.length()); // 파일크기
			}
		}
		
		System.out.println("받은 파일 객체 이름출력해보기");
		System.out.println(fileInput);  //fname
		System.out.println(fileName);   //9852620200130162926.jpg
		System.out.println(type);       //image/jpeg
		System.out.println(fileObj);    //D:\05. git_storage\BasicBoard\BasicBoard\WebContent\file\upload\9852620200130162926.jpg
		System.out.println(originFileName); //업로드테스트.jpg
		System.out.println(fileExtend);  //jpg
		System.out.println(fileSize);    //123804

		BoardVO vo = new BoardVO();
		vo.setlName(multi.getParameter("name"));
		vo.setlIp(multi.getParameter("ipaddr"));
		vo.setPmAddr(multi.getParameter("macaddr"));
		vo.setFname(fileName);

		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);

		new BoardPagingAction().execute(request, response);

	}

}
