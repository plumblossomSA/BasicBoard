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
		<h1>��ǻ�� ���</h1>
		<!-- <form name="frm" method="post" action="BoardServlet" enctype="multipart/form-data"> -->
		 	<form name="frm" method="post" action="BoardServlet?command=board_write"  enctype="multipart/form-data">
			<!-- <input type="hidden" name="command" value="board_write"> -->
			<table>
				<tr>
					<th>�������̸�</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>������IP�ּ�</th>
					<td><input type="text" name="ipaddr"></td>
				</tr>
				<tr>
					<th>PC_Mac�ּ�</th>
					<td><input type="text" name="macaddr"></td>
				</tr>
				<tr>
					<th>���� ���ε�</th>
					<td><input type="file" name="fname"></td>
				</tr>
				<!-- 	
	<tr>
		<th>�����</th>
		<td><input type="text" name="regdate"></td>
	</tr>
-->
			</table>
			<br> <br> <input type="submit" value="���"
				onclick="return boardCheck()">
			<!-- submit�� form�±� �ȿ� �ִ� ��絥���͸� �Է� �����͸� ó���ϴ� ��ũ��Ʈ�� �ִ� ���� �������� ���� -->
			<input type="button" value="���"
				onclick="location.href='BoardServlet?command=board_list_pg'">
		</form>
	</div>
</body>
</html>