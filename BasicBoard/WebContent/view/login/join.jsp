<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<body>
	<h3 align=center>회원 가입</h3>
	<form action="join.do" method="post" name="frm">
		<table align=center class="table table-bordered" style="width: 30; margin-left: auto; margin-right: auto; table-layout: fixed;">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" size="20"> <input
					type="hidden" name="reid" value=""> <input type="button"
					value="중복체크" onclick="idCheck()"></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="pwd" size="20"></td>
			</tr>
			<tr>
				<td>암호확인</td>
				<td><input type="text" name="email" size="20"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="20"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" size="20"></td>
			</tr>
			<tr>
				<td>관리자모드</td>
				<td><input type="radio" name="admin" value="0" checked>일반
					<input type="radio" name="admin" value="1">관리자</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="확인"
					onclick="return joinCheck()"> <input type="reset"
					value="취소">
		</table>
	</form>
</body>

<script type="text/javascript">
	function idCheck() {
		if (document.frm.userid.value == "") {
			alert("아이디를 입력해주세요.");
			document.frm.userid.focus();
			return;
		}

		var url = "idCheck.do?userid=" + document.frm.userid.value;

		var setting = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200";

		window.open(url, "_blank_1", setting);
	}

	function joinCheck() {
		if (document.frm.name.value.length == 0) {
			alert("이름을 입력하세요");
			frm.name.focus();
			return false;
		}
		if (document.frm.userid.value.length == 0) {
			alert("id를 입력하세요");
			frm.userid.focus();
			return false;
		}
		if (document.frm.userid.value.length < 4) {
			alert("id를 4글자 이상 입력하세요");
			frm.userid.focus();
			return false;
		}
		if (document.frm.pwd.value.length == 0) {
			alert("비밀번호를 입력하세요");
			frm.pwd.focus();
			return false;
		}
		if (document.frm.pwd.value != document.frm.pwd_check.value) {
			alert("비밀번호가 일치 하지 않습니다.");
			frm.pwd_check.focus();
			return false;
		}
		if (document.frm.reid.value.length == 0) {
			alert("중복체크를 해야합니다.");
			frm.userid.focus();
			return false;
		}

		return true;
	}
</script>

</html>