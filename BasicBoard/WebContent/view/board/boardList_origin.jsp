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


<div id="wrap" align="center">

<h1>리눅스 정보</h1>
<table class="list" border=1>
	


	<tr>
	<td colspan="2" style=" text-align:left"><a href="BoardServlet?command=board_write_form">컴퓨터등록</a></td>
	</tr>

	<tr>
		<!-- <th><div class="formDs check"><input type="checkbox" id="checkall"><label for="checkall"></label></div></th> -->
		<th>번호</th>
		<th>리눅스이름</th>
		<th>리눅스IP</th>
		<th>PC 맥 주소</th>
		<th>사용자수</th>
		<th>등록날짜</th>
	</tr>
	<c:forEach var="board" items="${boardList}">
		<tr>
		<!-- <td><div class="formDs check"><input type="checkbox" class="admin_chk"></div></td> -->
		<td><c:out value="${board.seq}"/></td>
		<td><a href="BoardServlet?command=board_view&seq=<c:out value="${board.seq}"/>"><c:out value="${board.lName}"/></a></td>
		<td><c:out value="${board.lIp}"/></td>
		<td><c:out value="${board.pmAddr}"/></td>
		<td><c:out value="${board.userCnt}"/></td>
		<td><c:out value="${board.regDate}"/></td>
		</tr>
	</c:forEach>
</table>
</div>

<script type="text/javascript">

<!--
$(document).ready(function(){
    $("#checkall").click(function(){
        if($("#checkall").prop("checked")){
            $(".admin_chk").prop("checked",true);
        }else{
            $(".admin_chk").prop("checked",false);
        }
    })
})


function checkAll(){
	
	if($("#checkall").is(':checked')){
		$("input[name=m_check]").prop("checked",true);
	}else{
		$("input[name=m_check]").prop("checked",false);
	}
	
}
-->

</script>
</body>
</html>


