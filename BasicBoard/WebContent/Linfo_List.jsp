<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.board.Linfo.*" %>
<%@page import="java.util.*" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div>
<h2>리눅스 정보</h2>

<table border=1">
<tr>
<th>NO</th>
<th>linux컴퓨터이름</th>
<th>IP주소</th>
<th>Mac주소</th>
<th>사용자수</th>
<th>등록일</th>


<%

LinfoDAO dao = new LinfoDAO();
ArrayList<LinfoDTO> list = dao.LinfoList();

//ArrayList<LinfoDTO> list = new ArrayList<LinfoDTO>();
//list = dao.l_list();

for(LinfoDTO dto : list){
%>

<tr>
<td><%=dto.getSeq() %></td>
<td><%=dto.getlName() %></td>
<td><%=dto.getlIp() %></td>
<td><%=dto.getPmAddr() %></td>
<td><%=dto.getUserCnt() %></td>
<td><%=dto.getRegDate() %></td>
</tr>

<% 
}
%>

</table>
</div>

</body>
</html>