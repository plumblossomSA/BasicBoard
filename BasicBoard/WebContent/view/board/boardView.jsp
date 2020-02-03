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
	<div id="Wrap" align="center">
	<br>
		<h3>컴퓨터이름 : ${boardview.lName}</h3>
		<table class="table table-bordered"
							style="width: 30; margin-left: auto; margin-right: auto; table-layout: fixed;">

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
			<tr>
				<th>상세파일</th>
				<!-- <td>${boardview.fname}</td> -->
				<td><a href="BoardServlet?command=board_download&fname=${boardview.fname}">${boardview.fname}</a></td>
			</tr>

		</table>
		<br> <a
			href="BoardServlet?command=board_update_form&seq=${boardview.seq}">수정</a>
		<a href="BoardServlet?command=board_delete&seq=${boardview.seq}">삭제</a>
		<!-- <input type="button" value="수정" onClick="location.href='boardUpdate.jsp'"> 
		<input type="button" value="삭제"> 
		<input type="button"value="게시글리스트">-->
	</div>
</body>
</html>