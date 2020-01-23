<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="Wrap" align="center">
		<h3>컴퓨터이름 : ${boardview.lName}</h3>
		<table border=1 class="list">

				<tr>
					<th>컴퓨터이름</th>
					<td>${boardview.lName}</td>
				</tr>
				<tr>
					<th>IP주소</th>
					<td>${boardview.lIp}</td>
				</tr>
				<tr>
					<th>PCMac주소</th>
					<td>${boardview.pmAddr}</td>
				</tr>

		</table>
		<br>
		<a href="BoardServlet?command=board_update_form&seq=${boardview.seq}">수정</a>
		<a href="BoardServlet?command=board_delete&seq=${boardview.seq}">삭제</a>
		<!-- <input type="button" value="수정" onClick="location.href='boardUpdate.jsp'"> 
		<input type="button" value="삭제"> 
		<input type="button"value="게시글리스트">-->
	</div>
</body>
</html>