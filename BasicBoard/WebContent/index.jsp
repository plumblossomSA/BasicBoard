<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@page import="com.board.List.*"%>
<%@page import="javax.servlet.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%

response.sendRedirect("BoardServlet?command=board_list_pg");
//response.sendRedirect("BoardServlet?command=board_List"); //BoardServlet.java로 command를 가지고 이동
//response.sendRedirect 페이지 이동

%>

</body>
</html>