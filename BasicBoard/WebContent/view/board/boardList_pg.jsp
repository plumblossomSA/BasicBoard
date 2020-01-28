<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


	<div id="wrap" align="center">
		<h1>������ ����</h1>

		<table class="list" border=1>
			<tr>
				<td colspan="7" style="text-align: left"><a
					href="BoardServlet?command=board_write_form">��ǻ�͵��</a></td>
			</tr>
			<tr>
				<th>��ȣ</th>
				<th>�������̸�</th>
				<th>������IP</th>
				<th>PC �� �ּ�</th>
				<th>����ڼ�</th>
				<th>��ϳ�¥</th>
			</tr>

			<div id="ContentsForm">
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td><c:out value="${board.seq}" /></td>
						<td><a
							href="BoardServlet?command=board_view&seq=<c:out value="${board.seq}"/>">
								<c:out value="${board.lName}" />
						</a></td>
						<td><c:out value="${board.lIp}" /></td>
						<td><c:out value="${board.pmAddr}" /></td>
						<td><c:out value="${board.userCnt}" /></td>
						<td><c:out value="${board.regDate}" /></td>
					</tr>
				</c:forEach>
			</div>
		</table>
			<br>
				<c:if test="${startPage != 1}">
					<a href='BoardServlet?command=board_paging&page=${startPage-1}'>[����]</a>
				</c:if>

				<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
					<c:if test="${pageNum == spage}"> ${pageNum} </c:if>
					<c:if test="${pageNum != spage}"><a href='BoardServlet?command=board_paging&page=${pageNum}'>${pageNum}</a></c:if>
				</c:forEach>
				
				<c:if test="${endPage != maxPage }">
					<a href='BoardServlet?command=board_paging&page=${endPage+1}'>[����]</a>
				</c:if>
		
	</div>


</body>
</html>


