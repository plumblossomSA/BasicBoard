<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2 align=center>�α���</h2>
	<form action="login.do" method="post" name="frm">
		<table align=center>
			<tr>
				<td>���̵�</td>
				<td><input type="text" name="userid" value="${userid}"></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2">
				    <input type="submit" value="�α���" onclick="return loginCheck()" /> 
					<input type="reset" value="���" />
					<input type="button" value="ȸ������" onclick="location.href='join.do'" />
				</td>
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
		</table>

	</form>

</body>
</html>