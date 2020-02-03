<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>아이디 중복확인</h2>

	<form action="idCheck.do" method="get" name="frm">
		아이디 <input type="text" name="userid" value="${userid}">
	
		<input type="submit" value="중복 체크"><br>

		<c:if test="${result == 1 }">
			<script type="text/javascript">
				// 현재 열려있는 창 window.의 userid값!
				opener.document.frm.userid.value = "";
			</script>
        ${userid}는 사용 중입니다.
    </c:if>

		<c:if test="${result == -1 }">
        ${userid}는 사용 가능한 아이디 입니다.
			<input type="button" value="사용" onclick="idOk('${userid}')">
		</c:if>


	</form>
</body>

<script type="text/javascript">
	function idOk(userid) {
		opener.frm.userid.value = userid;
		opener.frm.reid.value = userid;
		self.close();
	}
</script>
</html>