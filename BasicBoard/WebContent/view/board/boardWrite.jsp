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
	<div id="wrap" align="center">
	<br>
		<h3>컴퓨터 등록</h3>
		<!-- <form name="frm" method="post" action="BoardServlet" enctype="multipart/form-data"> -->
		 	<form name="frm" method="post" action="BoardServlet?command=board_write"  enctype="multipart/form-data" 
		 		accept-charset="utf-8">
			<!-- <input type="hidden" name="command" value="board_write"> -->
			<table class="table table-bordered"
							style="width: 30; margin-left: auto; margin-right: auto; table-layout: fixed;">
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

<script>


function boardCheck(){
	if(document.frm.name.value.length ==0){
		alert("컴퓨터 이름을 입력하세요");
		return false;
	}
	if(document.frm.ipaddr.value.length==0){
		alert("IP주소를 입력하세요");
		return false;
	}
	if(document.frm.macaddr.value.length==0){
		alert("Mac주소를 입력하세요");
		return false;
	}
//	if(document.frm.regdate.value.length==0){
//		alert("등록일을 입력하세요");
//		return false;
//	}
	return true;
	
}
</script>
</html>