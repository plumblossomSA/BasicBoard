<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page import="com.board.controller.*"%>
<%@page import="javax.servlet.*"%>

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
	position: relative;
	width: 100%;
	height: 880px;
	border: 0;
}

.sidenav {
	background-color: #e8e8e8;
	position: fixed;
	width: 300px;
	height: 100%;
	margin-left: -20px;
	margin-top: 0px
}
</style>

<body>

	<form action="login.do">
		<!-- header -->
		<nav class="navbar navbar-fixed-top" id="header">
		<div class="container-fluid">
			<div class="navbar-header">
			<div align="right">안녕하세요 ${loginUser.uname}({${loginUser.uid})님</div>
				<div class="brand">
					<a href="index.jsp"> <span class="hidden-xs-down m-r-3">Basic
							Board</span><span class="lead"></span></a>
				</div>
				
			</div>
		</div>
		</nav>
		<!-- /header -->



		<!-- sidebar -->
		<!-- <nav class="navbar navbar-inverse navbar-fixed-top">-->
		<nav class="col-sm-3 sidenav"> <!-- <div class="sidebar-toggle" id="sidebar"> -->
		<ul class="nav nav-sidebar">
			<li><a href="main_frame.jsp"> <i
					class="fa fa-clock-o fa-lg fa-fw" aria-hidden="true"></i> <span>MENU1</span>
			</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="main_frame.jsp" target="iframes"> <i
					class="fa fa-newspaper-o fa-lg fa-fw" aria-hidden="true"></i> <span>MENU2</span>
			</a></li>
			<li role="separator" class="divider"></li>
		</ul>
		<!-- </div> --> </nav>
		<!-- /sidebar -->


		<!-- page-content-wrapper -->
		<div class="page-content-toggle" id="page-content-wrapper">
			<div class="container-fluid" style="padding: 0rem; margin: 0rem">
				<iframe name="iframes" id='iframes'
					src="BoardServlet?command=board_list_pg"> </iframe>

			</div>
			<!-- page-content-wrapper -->
	</form>
</body>
</html>


