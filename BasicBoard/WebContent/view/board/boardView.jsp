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
		<h3>��ǻ���̸� : ${boardview.lName}</h3>
		<table border=1 class="list">

				<tr>
					<th>��ǻ���̸�</th>
					<td>${boardview.lName}</td>
				</tr>
				<tr>
					<th>IP�ּ�</th>
					<td>${boardview.lIp}</td>
				</tr>
				<tr>
					<th>PCMac�ּ�</th>
					<td>${boardview.pmAddr}</td>
				</tr>

		</table>
		<br>
		<a href="BoardServlet?command=board_update_form&seq=${boardview.seq}">����</a>
		<a href="BoardServlet?command=board_delete&seq=${boardview.seq}">����</a>
		<!-- <input type="button" value="����" onClick="location.href='boardUpdate.jsp'"> 
		<input type="button" value="����"> 
		<input type="button"value="�Խñ۸���Ʈ">-->
	</div>
</body>
</html>