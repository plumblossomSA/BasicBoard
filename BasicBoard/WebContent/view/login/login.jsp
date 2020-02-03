<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- stylesheets -->
<link href="assets/fonts/font-roboto.css" rel="stylesheet">
<link href="assets/bootstrap/bootstrap4-alpha3.min.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="assets/web-analytics/style.css" rel="stylesheet">

<!-- scripts -->
<script src="assets/jquery/jquery-3.1.0.min.js"></script>
<script src="assets/tether/tether.min.js"></script>
<script src="assets/bootstrap/bootstrap4-alpha3.min.js"></script>
<script src="assets/web-analytics/overview.js"></script>
</head>

<style>
#iframes {
	width: 100%;
	height: 360px;
	border: 0;
}

.iframes2 {
	width: 100%;
	height: 350px;
	border: 0;
}

* {
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

html, body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
<body>
	<br>
	<h2 align=center>로그인</h2>
	<form action="login.do" method="post" name="frm">
		<table align=center>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid" value="${uid}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="upw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="로그인"
					onclick="return loginCheck()" /> <input type="reset" value="취소" />
					<input type="button" value="회원 가입"
					onclick="location.href='join.do'"></td>
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
		</table>
	</form>
</body>

<script type="text/javascript">
	function loginCheck() {
		if (document.frm.userid.value.length == 0) {
			alert("아이디를 입력하세요");
			document.frm.userid.focus();

			return false;
		}

		if (document.frm.pwd.value.length == 0) {
			alert("비밀번호를 입력하세요");
			document.frm.pwd.focus();

			return flase;
		}

		return true;
	}
</script>


</html>