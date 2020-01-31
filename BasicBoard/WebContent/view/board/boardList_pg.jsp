<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" content="width=device-width, initial-scale=1, shrink-to-fit=no"> -->
<title>Insert title here</title>

<!-- BootStrap -->
<script type="text/javascript" src="assets/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="assets/css/bootstrap.css"/>
		
</head>
<body>


	<div id="wrap" align="center">
		<h3>리눅스 정보</h3>
		<!-- <table class="list" border=1> -->
		  <table class="table table-bordered" style="width:30; margin-left:auto; margin-right:auto; table-layout:fixed;">
		<!-- <table class="table table-bordered"> -->
		<!-- <table class="table table-hover"> -->

			<tr id="title">
				<td colspan="6" style="text-align: left"><a
					href="BoardServlet?command=board_write_form">컴퓨터등록</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>리눅스이름</th>
				<th>리눅스IP</th>
				<th >PC 맥 주소</th>
				<th>상세파일</th>
				<th>등록날짜</th>
			</tr>

			<div id="ContentsForm">
				<c:forEach var="board" items="${boardList}">
					<tr class="contents">
						<td><c:out value="${board.seq}" /></td>
						<td><a
							href="BoardServlet?command=board_view&seq=<c:out value="${board.seq}"/>">
								<c:out value="${board.lName}" /></a>
						</td>
						<td><c:out value="${board.lIp}" /></td>
						<td><c:out value="${board.pmAddr}" /></td>
						<td><a href="BoardServlet?command=board_download&fname=${board.fname}"><c:out value="${board.fname}" /></a></td>
						<td><c:out value="${board.regDate}" /></td>
					</tr>
				</c:forEach>
			</div>
		</table>
			<br>
				<c:if test="${startPage != 1}">
					<a href='BoardServlet?command=board_paging&page=${startPage-1}'>[이전]</a>
				</c:if>

				<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
					<c:if test="${pageNum == spage}"> ${pageNum} </c:if>
					<c:if test="${pageNum != spage}"><a href='BoardServlet?command=board_paging&page=${pageNum}'>${pageNum}</a></c:if>
				</c:forEach>
				
				<c:if test="${endPage != maxPage }">
					<a href='BoardServlet?command=board_paging&page=${endPage+1}'>[다음]</a>
				</c:if>
		
	</div>


</body>
</html>


