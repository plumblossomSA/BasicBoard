<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.board.controller.*"%>
<%@page import="javax.servlet.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8\">
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


<!--
//boardwrite함수 확인할떄
		System.out.println("받은 파일 객체 이름출력해보기");
		System.out.println(fileInput);  //fname
		System.out.println(fileName);   //9852620200130162926.jpg
		System.out.println(type);       //image/jpeg
		System.out.println(fileObj);    //D:\05. git_storage\BasicBoard\BasicBoard\WebContent\file\upload\9852620200130162926.jpg
		System.out.println(originFileName); //업로드테스트.jpg
		System.out.println(fileExtend);  //jpg
		System.out.println(fileSize);    //123804
	
-->
		