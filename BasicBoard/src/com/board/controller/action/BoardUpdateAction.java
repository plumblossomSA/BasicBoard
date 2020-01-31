package com.board.controller.action;

import com.board.vo.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.AImapFileRenamePolicy;
import com.board.dao.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardUpdateAction implements Action {

	@Override

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		BoardVO vo = new BoardVO();


		// 날짜처리
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format_time1 = format1.format(System.currentTimeMillis());

		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		vo.setlName(request.getParameter("name"));
		vo.setlIp(request.getParameter("ipaddr"));
		vo.setPmAddr(request.getParameter("macaddr"));
		vo.setRegDate(format_time1);

		BoardDAO dao = new BoardDAO();

		dao.updateBoard(vo);
		// new BoardListAction().execute(request, response);
		new BoardPagingAction().execute(request, response);
	}

}
