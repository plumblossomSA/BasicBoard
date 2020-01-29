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
		
		//���ε�� ������ ������
		String uploadPath = "D:\\05. git_storage\\BasicBoard\\BasicBoard\\WebContent\\file\\upload"; //������ ������ ���
		
		//���� �ִ������ 20MB
		int size = 20*1024*1024; 
		
		//�����ϸ��� cos.jar���� ���ε带 ���� �غ�
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		//���ε�� �����̸�
		String fname = multi.getFilesystemName("fname");
		
		File oldFile = new File(uploadPath+fname);
		
		//���ε�� ���� �̸� �ѱ�ȭ(���󿡼�)
		//�ѱ� ���ϸ��� ������ ����
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
		//-> �̹������ �ϸ� ���� ���ϸ��� 	%3F%3F%3F%3F%3F%3F%3F%3F.jpg ������ �ö󰡰�, ����� ���� ���ϸ��� ������ ����.
		//-> ������ �����ޱ� �Ҷ��� ���ϸ��� ________.jpg������ ���̸�, ���ϵ� ������.
		
		BoardVO vo = new BoardVO();
		
		vo.setlName(multi.getParameter("name")); //������ �ڹٷ� ������ �޾ƿ���
		vo.setlIp(multi.getParameter("ipaddr"));
		vo.setPmAddr(multi.getParameter("macaddr"));
		vo.setFname(fname);
		
		
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		new BoardPagingAction().execute(request, response);
		
	
	}
		

}
