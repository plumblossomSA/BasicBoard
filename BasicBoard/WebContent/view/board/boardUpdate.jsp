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
<h3>�Խñ� ����</h3>
<form action="BoardServlet" method="post" name="frm">
<input type="hidden" name="command" value="board_update">
<input type="hidden" name="seq" value="${boardview.seq}">

<table>
	<tr>
		<th>�������̸�</th>
		<td><input type="text" name="name" value="${boardview.lName}"></td>
	</tr>
	<tr>
		<th>������IP�ּ�</th>
		<td><input type="text" name="ipaddr" value="${boardview.lIp}"></td>
	</tr>
	<tr>
		<th>PC_Mac�ּ�</th>
		<td><input type="text" name="macaddr" value="${boardview.pmAddr}"></td>
	</tr>
	<tr>
		<th>���� ���ε�</th>
		<td><input type="text" name="file_upload"></td>
	</tr>
<!-- 	
	<tr>
		<th>�����</th>
		<td><input type="text" name="regdate"></td>
	</tr>
-->	
	</table>
	<br>
	<input type="submit" value="����" onclick="return boardCheck()"/>
</form>

<script>
function boardCheck(){
	if(document.frm.name.value.length==0){
		alert("��ǻ���̸��� �Է��ϼ���");
		frm.name.focus();
		return false;
	}
	if(document.frm.ipaddr.value.length==0){
		alert('IP�ּҸ� �Է��ϼ���');
		frm.ipaddr.focus();
		return false;
	}
	if(document.frm.ipaddr.value.length==0){
		alert('PC ���ּҸ� �Է��ϼ���');
		frm.macaddr.focus();
		return false;
	}
	return true;
}
</script>
</div>
</body>


</html>