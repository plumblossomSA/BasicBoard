package com.board.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardWriteFormAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.getRequestDispatcher("/boardWrite.jsp").forward(request, response);
	}

}
