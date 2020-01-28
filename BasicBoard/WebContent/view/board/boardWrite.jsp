<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>컴퓨터 등록</h1>
		<!-- <form name="frm" method="post" action="BoardServlet" enctype="multipart/form-data"> -->
		 	<form name="frm" method="post" action="BoardServlet?command=board_write"  enctype="multipart/form-data">
			<!-- <input type="hidden" name="command" value="board_write"> -->
			<table>
				<tr>
					<th>리눅스이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>리눅스IP주소</th>
					<td><input type="text" name="ipaddr"></td>
				</tr>
				<tr>
					<th>PC_Mac주소</th>
					<td><input type="text" name="macaddr"></td>
				</tr>
				<tr>
					<th>파일 업로드</th>
					<td><input type="file" name="fname"></td>
				</tr>
				<!-- 	
	<tr>
		<th>등록일</th>
		<td><input type="text" name="regdate"></td>
	</tr>
-->
			</table>
			<br> <br> <input type="submit" value="등록"
				onclick="return boardCheck()">
			<!-- submit은 form태그 안에 있는 모든데이터를 입력 데이터를 처리하는 스크립트가 있는 서버 페이지로 전송 -->
			<input type="button" value="목록"
				onclick="location.href='BoardServlet?command=board_list_pg'">
		</form>
	</div>
</body>
</html>