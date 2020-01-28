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
		

		// ������ ����� ���.
		String realPath = "D:\\05. git_storage\\BasicBoard\\BasicBoard\\WebContent\\file\\download\\";
		
		System.out.println("������ ����� ���");
		System.out.println(realPath);

		// ���� �̸��� �Ķ���ͷ� �Ѿ���� ������ �����̷�Ʈ ��Ų��.
		if(request.getParameter("fname") == null || "".equals(request.getParameter("fname"))){

			response.sendRedirect("/view/board/boardView.jsp");

		}else{

			// �Ķ���ͷ� ���� ���� �̸�.
			String requestFileNameAndPath = request.getParameter("fname");
			System.out.println("���μ��� Ȯ����1");
			
			// �������� ����ã�� ���� �ʿ��� �����̸�(��θ� �����ϰ� ����)
			// �ѱ� �̸��� ���ϵ� ã�� �� �ֵ��� �ϱ� ���ؼ� ���ڼ� �����ؼ� �ѱ۷� �ٲ۴�.
			String UTF8FileNameAndPath = new String(requestFileNameAndPath.getBytes("8859_1"), "UTF-8");
			System.out.println("���μ��� Ȯ����2");
			
			// �����̸����� path�� �߶󳻰� ���ϸ� �����Ѵ�.
			String UTF8FileName = UTF8FileNameAndPath.substring(UTF8FileNameAndPath.lastIndexOf("/") + 1).substring(UTF8FileNameAndPath.lastIndexOf(File.separator) + 1);
			System.out.println("���μ��� Ȯ����3");
			
			// �������� IE���� Ȯ���� �÷���.
			boolean MSIE = request.getHeader("user-agent").indexOf("MSIE") != -1;
			System.out.println("���μ��� Ȯ����4");
			
			// ���� �ٿ�ε� �� ���� �� ����� ���ϸ�
			String fileNameToSave = "";
			System.out.println("���μ��� Ȯ����5");

			// IE,FF ���� �ٸ��� �����̸��� �����ؼ� �������־�� �Ѵ�.
			if(MSIE){
				// �������� IE�� ��� ����� ���� �̸�
				// ������ '+'�� ���ڵ��Ȱ��� �ٽ� �������� �ٲ��ش�.
				fileNameToSave = URLEncoder.encode(UTF8FileName, "UTF8").replaceAll("\\+", " ");
				System.out.println("���μ��� Ȯ����6");
			}else{
				// �������� IE�� �ƴ� ��� ����� ���� �̸�
				fileNameToSave = new String(UTF8FileName.getBytes("UTF-8"), "8859_1");
				System.out.println("���μ��� Ȯ����7");
			}

			// �ٿ�ε� �˸�â�� �ߵ��� �ϱ� ���ؼ� ����Ʈ Ÿ���� 8��Ʈ ���̳ʸ��� �����Ѵ�.
			response.setContentType("application/octet-stream");
			System.out.println("���μ��� Ȯ����8");
			
			// ����� ���� �̸��� �����Ѵ�.
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameToSave + "\";");
			System.out.println("���μ��� Ȯ����9");

			
			// �����н� �� ���ϸ��� �����Ѵ�.
			//  String filePathAndName = pageContext.getServletContext().getRealPath("/") + UTF8FileNameAndPath;
			String filePathAndName = realPath + UTF8FileNameAndPath;
			File file = new File(filePathAndName);
			System.out.println("���μ��� Ȯ����10");
			
			// ���� ũ�� ����
			byte bytestream[] = new byte[2048000];
			System.out.println("���μ��� Ȯ����11");

			// response out�� ���� ������ ����Ѵ�.
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

